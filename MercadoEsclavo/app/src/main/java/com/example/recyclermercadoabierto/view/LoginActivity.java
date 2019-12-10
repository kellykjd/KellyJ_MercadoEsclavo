package com.example.recyclermercadoabierto.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.recyclermercadoabierto.R;
import com.example.recyclermercadoabierto.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;
    private FirebaseAuth auth;
    private FirebaseStorage storage;
    private FirebaseUser currentUser;
    private ImageView imagenLogo;
    private static final String COLLECTION_USERS = "Usuarios";
    private TextInputLayout textInputLayoutNombre;
    private TextInputLayout textInputLayoutApellido;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private TextInputEditText editTextNombre;
    private TextInputEditText editTextApellido;
    private TextInputEditText editTextEmail;
    private TextInputEditText editTextPassword;
    private Button botonIngresar;
    private Button botonRegistrate;
    private TextView textViewInfoRegistrar;
    private TextView textViewRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent intent = getIntent();
        encontrarVistas();
        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        textViewRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCampos();
                mostrarCamposRegistro();
            }
        });


        botonRegistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validarCamposRegistro()){
                    crearUsuario(editTextEmail.getText().toString(), editTextPassword.getText().toString());
                }            }
        });
        botonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validarCamposIngreso()){
                    ingresarUsuario(editTextEmail.getText().toString(), editTextPassword.getText().toString());
                }
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
        if (currentUser != null){
            startActivity(new Intent(this,MainActivity.class));
        }
    }

    private void crearUsuario(String email, String password){
        String nombre = editTextNombre.getText().toString();
        String apellido = editTextApellido.getText().toString();
        final Usuario usuario = new Usuario(nombre,apellido);

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("FirebaseLogin", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            resetCampos();
                            esconderCamposRegistro();

                            firestore.collection(COLLECTION_USERS)
                                    .document(user.getUid())
                                    .set(usuario);

                            Toast.makeText(LoginActivity.this, "Registro exitoso. Inicie sesión para continuar.",Toast.LENGTH_SHORT).show();

                        //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("FirebaseCreateUser", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
                });
    }

    private void ingresarUsuario(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("firbaseLogin", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("FirebaseCreateUser", "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }

    private void encontrarVistas(){
        imagenLogo = findViewById(R.id.loginActivity_imageView_logo);
        textInputLayoutNombre = findViewById(R.id.loginActivity_textInputLayout_nombre);
        textInputLayoutApellido = findViewById(R.id.loginActivity_textInputLayout_apellido);
        textInputLayoutEmail = findViewById(R.id.loginActivity_textInputLayout_email);
        textInputLayoutPassword = findViewById(R.id.loginActivity_textInputLayout_password);
        editTextNombre = findViewById(R.id.loginActivity_textInputEditText_nombre);
        editTextApellido = findViewById(R.id.loginActivity_textInputEditText_apellido);
        editTextEmail = findViewById(R.id.loginActivity_textInputEditText_email);
        editTextPassword = findViewById(R.id.loginActivity_textInputEditText_password);
        botonIngresar = findViewById(R.id.loginActivity_button_ingresar);
        botonRegistrate = findViewById(R.id.loginActivity_button_registrate);
        textViewInfoRegistrar = findViewById(R.id.loginActivity_textView_infoRegistrar);
        textViewRegistrarse = findViewById(R.id.loginActivity_textView_registrar);
    }

    private void mostrarCamposRegistro(){
        textInputLayoutNombre.setVisibility(View.VISIBLE);
        textInputLayoutApellido.setVisibility(View.VISIBLE);
        editTextNombre.setVisibility(View.VISIBLE);
        editTextApellido.setVisibility(View.VISIBLE);
        botonRegistrate.setVisibility(View.VISIBLE);
        botonIngresar.setVisibility(View.GONE);
        textViewRegistrarse.setVisibility(View.GONE);
        textViewInfoRegistrar.setVisibility(View.GONE);
    }

    private void esconderCamposRegistro(){
        textInputLayoutNombre.setVisibility(View.GONE);
        textInputLayoutApellido.setVisibility(View.GONE);
        editTextNombre.setVisibility(View.GONE);
        editTextApellido.setVisibility(View.GONE);
        botonRegistrate.setVisibility(View.GONE);
        botonIngresar.setVisibility(View.VISIBLE);
        textViewRegistrarse.setVisibility(View.VISIBLE);
        textViewInfoRegistrar.setVisibility(View.VISIBLE);
    }

    private Boolean validarCamposIngreso(){
        Boolean todoOk = true;
        resetErrores();
        if(editTextPassword.getText().toString().length()<6){
            textInputLayoutPassword.setError("La contraseña es muy corta");
            todoOk=false;
        }else if(!editTextEmail.getText().toString().contains("@") || !editTextEmail.getText().toString().contains(".")){
            textInputLayoutEmail.setError("El formato de correo es inválido");
            todoOk=false;
        }
        return todoOk;
    }

    private Boolean validarCamposRegistro(){
        Boolean todoOk = true;
        textInputLayoutPassword.setError(null);
        if(editTextNombre.getText().toString().length()<3) {
            textInputLayoutNombre.setError("El nombre es muy corto.");
            todoOk=false;
        }else if(editTextApellido.getText().toString().length()<3) {
            textInputLayoutApellido.setError("El apellido es muy corto.");
            todoOk=false;
        }else if(editTextPassword.getText().toString().length()<6){
            textInputLayoutPassword.setError("La contraseña es muy corta");
            todoOk=false;
        }else if(editTextEmail.getText().toString().length()<6 || !editTextEmail.getText().toString().contains("@") || !editTextEmail.getText().toString().contains(".")){
            textInputLayoutEmail.setError("El formato de correo es inválido");
            todoOk=false;
        }
        return todoOk;
    }

    private void resetCampos(){
        editTextNombre.setText("");
        editTextApellido.setText("");
        editTextEmail.setText("");
        editTextPassword.setText("");
        editTextNombre.clearFocus();
        editTextApellido.clearFocus();
        editTextEmail.clearFocus();
        editTextPassword.clearFocus();
    }

    private void resetErrores(){
        textInputLayoutNombre.setError(null);
        textInputLayoutApellido.setError(null);
        textInputLayoutEmail.setError(null);
        textInputLayoutPassword.setError(null);
    }

}
