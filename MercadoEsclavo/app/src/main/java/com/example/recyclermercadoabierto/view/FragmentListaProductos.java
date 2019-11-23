package com.example.recyclermercadoabierto.view;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclermercadoabierto.R;
import com.example.recyclermercadoabierto.controller.ProductoController;
import com.example.recyclermercadoabierto.model.Producto;
import com.example.recyclermercadoabierto.utils.ResultListener;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListaProductos extends Fragment implements AdapterProductos.ListenerDelAdapter {
    private RecyclerView recyclerView;
    private ListenerDeFragment listenerDeFragment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_productos, container, false);
        recyclerView =view.findViewById(R.id.fragmentListaProductos_recyclerView);
        final AdapterProductos adapterProductos = new AdapterProductos(this);
        ProductoController productoController = new ProductoController();

        productoController.buscarProductos("Celulares", new ResultListener<List<Producto>>() {
            @Override
            public void finish(List<Producto> results) {
                adapterProductos.setProductoList(results);
            }
        });




        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(adapterProductos);
        return view;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listenerDeFragment = (ListenerDeFragment) context;
    }

    @Override
    public void informarProductoSeleccionado(Producto producto) {
        listenerDeFragment.recibirProducto(producto);
    }


    public interface ListenerDeFragment {
        public void recibirProducto(Producto producto);
    }
}
