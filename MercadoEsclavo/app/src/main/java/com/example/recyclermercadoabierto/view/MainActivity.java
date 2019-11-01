package com.example.recyclermercadoabierto.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.recyclermercadoabierto.R;
import com.example.recyclermercadoabierto.model.Producto;

public class MainActivity extends AppCompatActivity implements FragmentListaProductos.ListenerDeFragment{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pegarFragment(new FragmentListaProductos());
    }

    private void pegarFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainActivity_container,fragment)
                .addToBackStack(null)
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
