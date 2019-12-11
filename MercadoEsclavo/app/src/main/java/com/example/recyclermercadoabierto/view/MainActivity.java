package com.example.recyclermercadoabierto.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.recyclermercadoabierto.R;
import com.example.recyclermercadoabierto.model.Resultado;
import com.example.recyclermercadoabierto.model.Usuario;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity implements FragmentListaProductos.ListenerDeFragment,NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private LinearLayout textViewCinta;
    private TextView textViewUser;
    private TextView textViewNombre;
    private ImageView imageViewFoto;
    private FirebaseFirestore firestore;
    private static final String COLLECTION_USERS = "Usuarios";

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        encontrarVistas();
        firestore= FirebaseFirestore.getInstance();
        actualizarInfoUsuario();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        cargarNavigationView();
        pegarFragment(new FragmentListaProductos(),false);

    }

    @Override
    public void onBackPressed() {
        textViewCinta.setVisibility(View.VISIBLE);
        toolbar.getMenu().getItem(0).setVisible(true);
        super.onBackPressed();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);

       MenuItem searchItem = menu.findItem(R.id.action_search);
       SearchView searchView =(SearchView) searchItem.getActionView();
       searchView.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                buscarProducto(query);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic
                return false;
            }
        });
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Integer id = menuItem.getItemId();
        switch (id) {
            case R.id.menuPrincipal_home:
                finish();
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.menuPrincipal_perfil:
                if(FirebaseAuth.getInstance().getCurrentUser()!=null){
                    textViewCinta.setVisibility(View.GONE);
                    toolbar.getMenu().getItem(0).setVisible(false);
                    pegarFragment(new FragmentPerfil(),true);
                }else{
                startActivity(new Intent(this,LoginActivity.class));
                finish();
                }
                break;
            case R.id.menuPrincipal_aboutUs:
                textViewCinta.setVisibility(View.GONE);
                FragmentAboutUs fragmentAboutUs = new FragmentAboutUs();
                pegarFragment(fragmentAboutUs,true);
                toolbar.getMenu().getItem(0).setVisible(false);
                break;
            case R.id.menuPrincipal_logout:
                FirebaseAuth.getInstance().signOut();
                actualizarInfoUsuario();
                startActivity(new Intent(this,MainActivity.class));
                Toast.makeText(this, "Sesión finalizada", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawers();
        return true;
    }

    private void cargarNavigationView(){
        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(this,
                        drawerLayout,
                        toolbar,
                        R.string.open_drawer,
                        R.string.close_drawer);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    private void encontrarVistas(){
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.mainActivity_drawerLayout);
        navigationView=findViewById(R.id.navigationView);
        //searchView = findViewById(R.id.search_view);
        textViewCinta = findViewById(R.id.mainActivity_cinta);
        textViewUser=findViewById(R.id.mainActivity_cinta_textViewUser);
        View headerView = navigationView.getHeaderView(0);
        textViewNombre=headerView.findViewById(R.id.headerNavigationView_textView_nombre);
        imageViewFoto=headerView.findViewById(R.id.headerNavigationView_imageView_foto);
    }

    private void pegarFragment(Fragment fragment, Boolean addToBackStack){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (addToBackStack){
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.replace(R.id.mainActivity_container,fragment,null)
                .commitAllowingStateLoss();
    }

    @Override
    public void recibirProducto(Resultado resultado) {
        FragmentDetalleProducto fragmentDetalleProducto =new FragmentDetalleProducto();
        Bundle bundle = new Bundle();
        bundle.putSerializable(FragmentDetalleProducto.CLAVE_PRODUCTO, resultado);
        fragmentDetalleProducto.setArguments(bundle);
        pegarFragment(fragmentDetalleProducto,true);
    }

    private void buscarProducto(String unaPalabra){
        FragmentListaProductos fragmentListaProductos = new FragmentListaProductos();
        Bundle bundle = new Bundle();
        bundle.putString(FragmentListaProductos.CLAVE_PALABRA,unaPalabra);
        fragmentListaProductos.setArguments(bundle);
        pegarFragment(fragmentListaProductos,true);
    }


    private void actualizarInfoUsuario(){
        try{

            //apunto a la coleccion de users
            firestore.collection(COLLECTION_USERS)
                    //apuntas al documento con el id del usuario que es unico
                    .document(FirebaseAuth.getInstance().getCurrentUser().getUid())
                    // traes el documento entero
                    .get()
                    //como es un pedido a una base de dato es async entonces le ponesun succes listener
                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            //te trae el json con la info del usuario
                            Usuario usuario = documentSnapshot.toObject(Usuario.class);
                            //si el usuario es distinto de nulo
                                textViewUser.setText("Hola "+usuario.getNombre()+", mirá lo que llegó");
                                textViewNombre.setText(usuario.getNombre()+" "+usuario.getApellido());
                                    Glide.with(MainActivity.this)
                                            .load(usuario.getImagenUrl())
                                            .into(imageViewFoto);
                                }


                    });

        }catch(Exception e){
            Log.d("MOSTRAR USUARIO","como no hay usuario logueado, se muestra la info por defecto");
            textViewUser.setText("Hola, mirá lo que llegó");
            textViewNombre.setText("Bienvenido");
            navigationView.getMenu().getItem(1).setTitle("Iniciar sesión");
            navigationView.getMenu().getItem(3).setVisible(false);
        }
    }
}
