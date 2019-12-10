package com.example.recyclermercadoabierto.view;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.recyclermercadoabierto.R;
import com.example.recyclermercadoabierto.model.Usuario;
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
import java.io.IOException;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPerfil extends Fragment {
    private Uri uri;
    private static final String COLLECTION_USERS = "Usuarios";
    private int PICK_IMAGE_REQUEST = 1;
    private FirebaseFirestore firestore;
    private FirebaseStorage storage;
    private FirebaseUser currentUser;
    private ImageView imageViewFoto;
    private TextView textViewEditarFoto;
    private TextInputLayout textInputLayoutNombre;
    private TextInputLayout textInputLayoutApellido;
    private TextInputEditText editTextNombre;
    private TextInputEditText editTextApellido;
    private Button botonSubirImagen;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        imageViewFoto = view.findViewById(R.id.fragmentPerfil_imageView_foto);
        textViewEditarFoto = view.findViewById(R.id.fragmentPerfil_textView_editFoto);
        botonSubirImagen = view.findViewById(R.id.fragmentPerfil_button_actualizar);
        editTextNombre = view.findViewById(R.id.fragmentPerfil_textInputEditText_nombre);
        editTextApellido = view.findViewById(R.id.fragmentPerfil_textInputEditText_apellido);
        storage = FirebaseStorage.getInstance();
        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        firestore = FirebaseFirestore.getInstance();

        traerUsuarioLogueado();

        textViewEditarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseImage();
            }
        });

        botonSubirImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarImagenAFirebase();
                String nombreUsuario = editTextNombre.getText().toString();
                String apellidoUsuario = editTextApellido.getText().toString();
                Usuario usuario = new Usuario(nombreUsuario, apellidoUsuario);
                guardarInfoUsuario(usuario);
                startActivity(new Intent(getActivity(),MainActivity.class));
            }
        });


    return view;
}

    public void chooseImage() {

        //tira un intent
        Intent intent = new Intent();
        //elije el tipo de intent que es en este caso es elegir una imagen
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        //el star image for result manda in intent a los perisfericos, el request code es lo que me perimite identificar de donde vino por si hago
        //muchos en una misma activity
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        // si el reques code es el del intent de la camara, y el result code es exitoso, y la data o la info de la dat no viene en null
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            uri = data.getData();
            try {
                //uso una clase que me da android para tranformar el uri en un bitmap
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                //le seteo el bitmap al image view
                imageViewFoto.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void cargarImagenAFirebase() {
        //creo una referencia en el storage, cada child es un carpeta y el child final es el nombre del archivo
        StorageReference path = storage.getReference().child("ProfilePics").child(currentUser.getUid());

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {


        //agarra el bitmap del imagae view en forma de drawable
        Bitmap bm=((BitmapDrawable) imageViewFoto.getDrawable()).getBitmap();
        //comprimer el bitmap
        bm.compress(Bitmap.CompressFormat.JPEG,10,byteArrayOutputStream);
        //lo Tranforma en un array de datos
        byte[] data = byteArrayOutputStream.toByteArray();
        UploadTask uploadTask = path.putBytes(data);
        //intenta subir a la referencia que creamos la imagen como es asyncronico le creamos un on complete listener para ver que hace cunado termina
        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(getActivity(), "imagen Cargada exitosamente", Toast.LENGTH_SHORT).show();
            }
        });}catch(Exception e){
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

        cargarImagenDelStorageAlDatabase();

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
