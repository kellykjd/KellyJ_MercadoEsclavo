package com.example.recyclermercadoabierto.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclermercadoabierto.R;
import com.example.recyclermercadoabierto.model.Producto;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetalleProducto extends Fragment {

    public static final String CLAVE_PRODUCTO = "claveProducto";
    private TextView textViewNombre;
    private TextView textViewDescripcion;
    private TextView textViewPrecio;
    private ImageView imageViewProducto;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

            View view = inflater.inflate(R.layout.fragment_detalle_producto, container, false);

            textViewNombre = view.findViewById(R.id.fragmentDetalleProducto_TextView_nombre);
            textViewDescripcion = view.findViewById(R.id.fragmentDetalleProducto_TextView_descripición);
            textViewPrecio = view.findViewById(R.id.fragmentDetalleProducto_TextView_precio);
            imageViewProducto = view.findViewById(R.id.fragmentDetalleProducto_ImageView_foto);
            Bundle bundle = getArguments();
            Producto productoSeleccionado =(Producto) bundle.getSerializable(CLAVE_PRODUCTO);
            imageViewProducto.setImageResource(productoSeleccionado.getFoto());
            textViewNombre.setText(productoSeleccionado.getNombre());
            textViewDescripcion.setText(productoSeleccionado.getDescripcion());
            textViewPrecio.setText(productoSeleccionado.getPrecio());
            return view;
    }

}
