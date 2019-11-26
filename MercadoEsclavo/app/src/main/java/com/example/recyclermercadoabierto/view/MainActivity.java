package com.example.recyclermercadoabierto.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.text.Layout;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclermercadoabierto.R;
import com.example.recyclermercadoabierto.model.Producto;
import com.google.android.material.navigation.NavigationView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity implements FragmentListaProductos.ListenerDeFragment,NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private MaterialSearchView searchView;
    private LinearLayout textViewCinta;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.SplashTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        encontrarVistas();
        setSupportActionBar(toolbar);
        searchView.setVoiceSearch(true);
        searchView.setCursorDrawable(R.drawable.color_cursor_white);
        cargarNavigationView();
        pegarFragment(new FragmentListaProductos(),false);
        searchView.setVoiceSearch(true);
        searchView.setCursorDrawable(R.drawable.custom_cursor);
/*       // Get ActionBar.
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();

        // Set below attributes to add logo in ActionBar.
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setIcon(R.drawable.logo);
        //actionBar.setLogo(R.drawable.logo);*/
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {



            @Override
            public boolean onQueryTextSubmit(String query) {
                buscarProducto(query);
                searchView.clearFocus();

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
            }
        });


    }


/*
    @Override
    public void onBackPressed() {
        if (searchView.isSearchOpen()) {
            searchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }
*/


    @Override
    public void onBackPressed() {
        searchView.closeSearch();
        textViewCinta.setVisibility(View.VISIBLE);
        super.onBackPressed();

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);

       MenuItem item = menu.findItem(R.id.action_search);
       searchView.setMenuItem(item);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){

/*      DEJARÉ ESTO AQUÍ POR SI QUIERO AGREGAR OTRAS OPCIONES AL MENÚ DE LA TOOLBAR
            case R.id.verCarrito:
            Toast.makeText(MainActivity.this, "Pendiente por programar", Toast.LENGTH_LONG).show();
            break;
*/

        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Integer id = menuItem.getItemId();
        switch (id) {
            case R.id.menuPrincipal_perfil:
                Toast.makeText(this, "Por programar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuPrincipal_favoritos:
                Toast.makeText(this, "Por programar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuPrincipal_aboutUs:
                textViewCinta.setVisibility(View.GONE);
                FragmentAboutUs fragmentAboutUs = new FragmentAboutUs();
                pegarFragment(fragmentAboutUs,true);
                break;
            case R.id.menuPrincipal_logout:
                Toast.makeText(this, "Por programar", Toast.LENGTH_SHORT).show();
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
        searchView = findViewById(R.id.search_view);
        textViewCinta = findViewById(R.id.mainActivity_cinta);
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
    public void recibirProducto(Producto producto) {

        FragmentDetalleProducto fragmentDetalleProducto =new FragmentDetalleProducto();
        Bundle bundle = new Bundle();
        bundle.putSerializable(FragmentDetalleProducto.CLAVE_PRODUCTO,producto);
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

}
