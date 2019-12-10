package com.example.recyclermercadoabierto.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclermercadoabierto.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPerfil extends Fragment {

    private static final String COLLECTION_USERS = "Usuarios";
    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;
    private FirebaseAuth auth;
    private FirebaseStorage storage;
    private FirebaseUser currentUser;
    private ImageView imagenFoto;
    private TextView textViewEditarFoto;
    private TextInputLayout textInputLayoutNombre;
    private TextInputLayout textInputLayoutApellido;
    private TextInputLayout textInputLayoutPassword;
    private TextInputEditText editTextNombre;
    private TextInputEditText editTextApellido;
    private TextInputEditText editTextEmail;
    private TextInputEditText editTextPassword;
    private Button botonActualizar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

         return view;
    }

}
