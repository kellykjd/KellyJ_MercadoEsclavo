package com.example.recyclermercadoabierto.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.recyclermercadoabierto.R;
import com.example.recyclermercadoabierto.model.Producto;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements FragmentListaProductos.ListenerDeFragment,NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.SplashTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        encontrarVistas();
        setSupportActionBar(toolbar);
        cargarNavigationView();
        pegarFragment(new FragmentListaProductos());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){

/*
            case R.id.verCarrito:
            Toast.makeText(MainActivity.this, "Pendiente por programar", Toast.LENGTH_LONG).show();
            break;
*/
            case R.id.buscar:
            Toast.makeText(MainActivity.this, "Pendiente por programar", Toast.LENGTH_LONG).show();
            break;
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
                Toast.makeText(this, "Por programar", Toast.LENGTH_SHORT).show();
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
    }

    private void pegarFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainActivity_container,fragment)
                .commit();
    }

    @Override
    public void recibirProducto(Producto producto) {

        FragmentDetalleProducto fragmentDetalleProducto =new FragmentDetalleProducto();
        Bundle bundle = new Bundle();
        bundle.putSerializable(FragmentDetalleProducto.CLAVE_PRODUCTO,producto);
        fragmentDetalleProducto.setArguments(bundle);
        pegarFragment(fragmentDetalleProducto);
    }
}
