package com.example.recyclermercadoabierto.view;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.recyclermercadoabierto.R;
import com.example.recyclermercadoabierto.controller.ProductoController;
import com.example.recyclermercadoabierto.model.Producto;
import com.example.recyclermercadoabierto.utils.ResultListener;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.List;

import static android.widget.LinearLayout.VERTICAL;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListaProductos extends Fragment implements AdapterProductos.ListenerDelAdapter {
    private RecyclerView recyclerView;
    private ListenerDeFragment listenerDeFragment;
    public static final String CLAVE_PALABRA = "unaPalabra";
    private ImageView imageViewBanner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
                View view = inflater.inflate(R.layout.fragment_lista_productos, container, false);
                recyclerView =view.findViewById(R.id.fragmentListaProductos_recyclerView);
                imageViewBanner = view.findViewById(R.id.fragmentListaProductos_imageView_Banner);

        Bundle bundle = getArguments();
        buscarProducto("0",20);

        try {
            if (bundle.isEmpty()) {
                buscarProducto("0",20);

            }else{
                String palabraBuscada = bundle.getString(CLAVE_PALABRA);
                imageViewBanner.setVisibility(View.GONE);
                buscarProducto(palabraBuscada,30);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    private void buscarProducto(String unaPalabra, Integer unLimite){
        final AdapterProductos adapterProductos = new AdapterProductos(this);
        final ProductoController productoController = new ProductoController();

        productoController.buscarProductos(unaPalabra, unLimite,new ResultListener<List<Producto>>() {
            @Override
            public void finish(List<Producto> results) {
                adapterProductos.setProductoList(results);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapterProductos);
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