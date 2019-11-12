package com.example.recyclermercadoabierto.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.recyclermercadoabierto.R;
import com.example.recyclermercadoabierto.model.Producto;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements FragmentListaProductos.ListenerDeFragment{

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.SplashTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

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
