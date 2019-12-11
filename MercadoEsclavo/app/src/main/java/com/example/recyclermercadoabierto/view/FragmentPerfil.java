package com.example.recyclermercadoabierto.view;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.recyclermercadoabierto.R;
import com.example.recyclermercadoabierto.model.Usuario;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPerfil extends Fragment {
    private Uri uri;
    private static final String COLLECTION_USERS = "Usuarios";
    private int ESCOGER_IMAGEN_REQUEST = 1;
    private FirebaseFirestore firestore;
    private FirebaseStorage storage;
    private FirebaseUser currentUser;
    private ImageView imageViewFoto;
    private TextView textViewEditarFoto;
    private TextInputLayout textInputLayoutNombre;
    private TextInputLayout textInputLayoutApellido;
    private TextInputEditText editTextNombre;
    private TextInputEditText editTextApellido;
    private Button botonActualizar;
    private ProgressDialog progressDialog;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        encontrarVistas(view);

        storage = FirebaseStorage.getInstance();
        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        firestore = FirebaseFirestore.getInstance();
        progressDialog= new ProgressDialog(getActivity());

        traerUsuarioLogueado();

        textViewEditarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                escogerImagen();
            }
        });

        botonActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setMessage("Actualizando perfil");
                progressDialog.show();
                String nombreUsuario = editTextNombre.getText().toString();
                String apellidoUsuario = editTextApellido.getText().toString();
                Usuario usuario = new Usuario(nombreUsuario, apellidoUsuario);
                guardarInfoUsuario(usuario);
                cargarImagenAFirebase();
            }
        });
    return view;
}


    private void encontrarVistas(View view){
        imageViewFoto = view.findViewById(R.id.fragmentPerfil_imageView_foto);
        textViewEditarFoto = view.findViewById(R.id.fragmentPerfil_textView_editFoto);
        botonActualizar = view.findViewById(R.id.fragmentPerfil_button_actualizar);
        textInputLayoutNombre = view.findViewById(R.id.fragmentPerfil_textInputLayout_nombre);
        editTextNombre = view.findViewById(R.id.fragmentPerfil_textInputEditText_nombre);
        textInputLayoutApellido = view.findViewById(R.id.fragmentPerfil_textInputLayout_apellido);
        editTextApellido = view.findViewById(R.id.fragmentPerfil_textInputEditText_apellido);
    }

    public void escogerImagen() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), ESCOGER_IMAGEN_REQUEST);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == ESCOGER_IMAGEN_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            uri = data.getData();
            try {
                imageViewFoto.setImageURI(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void cargarImagenAFirebase() {
        StorageReference path = storage.getReference().child("ProfilePics").child(currentUser.getUid());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
        Bitmap bm=((BitmapDrawable) imageViewFoto.getDrawable()).getBitmap();
        bm.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] data = byteArrayOutputStream.toByteArray();
        UploadTask uploadTask = path.putBytes(data);
        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(getActivity(), "Perfil actualizado", Toast.LENGTH_SHORT).show();
                cargarImagenDelStorageAlDatabase();
                getActivity().finish();
                startActivity(new Intent(getActivity(),MainActivity.class));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void guardarInfoUsuario(final Usuario usuario){
        //apunto a la coleccion de users
        firestore.collection(COLLECTION_USERS)
                //apuntas al documento con el id del usuario que es unico
                .document(currentUser.getUid())
                // le seteas el usuario, firestore ya sabe mapearlo y subirlo al json
                .set(usuario);
        //cargarImagenDelStorageAlDatabase();
    }

    private void cargarImagenDelStorageAlDatabase() {
        //agarro el path donde subi la imagen usando el user id para encontrarlo
        StorageReference path = storage.getReference().child("ProfilePics").child(currentUser.getUid());

        //le pido el download url asi puedo cargarlo en el storage y tener mas facil acceso sin tener que anidar pedidos
        path.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                //le hago un update a mi usuario con la url de la imagen en firestore
                firestore.collection(COLLECTION_USERS)
                        .document(currentUser.getUid())
                        .update("imagenUrl",uri.toString());
            }
        });
    }

    private void traerUsuarioLogueado(){
        //apunto a la coleccion de users
        firestore.collection(COLLECTION_USERS)
                //apuntas al documento con el id del usuario que es unico
                .document(currentUser.getUid())
                // traes el documento entero
                .get()
                //como es un pedido a una base de dato es async entonces le ponesun succes listener
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        //te trae el json con la info del usuario
                        Usuario usuario = documentSnapshot.toObject(Usuario.class);
                        //si el usuario es distinto de nulo
                        if(usuario != null){
                            editTextNombre.setText(usuario.getNombre());
                            editTextApellido.setText(usuario.getApellido());
                            if(usuario.getImagenUrl() != null){
                                Glide.with(getContext())
                                        .load(usuario.getImagenUrl())
                                        .into(imageViewFoto);
                            }
                        }
                    }
                });

    }

}
