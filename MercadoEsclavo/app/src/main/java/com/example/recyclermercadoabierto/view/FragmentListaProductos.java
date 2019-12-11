package com.example.recyclermercadoabierto.view;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.recyclermercadoabierto.R;
import com.example.recyclermercadoabierto.controller.ResultadoController;
import com.example.recyclermercadoabierto.model.Resultado;
import com.example.recyclermercadoabierto.utils.ResultListener;

import java.util.List;

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
        final ResultadoController resultadoController = new ResultadoController();

        resultadoController.buscarProductos(unaPalabra, unLimite,new ResultListener<List<Resultado>>() {
            @Override
            public void finish(List<Resultado> results) {
                adapterProductos.setResultadoList(results);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(adapterProductos);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listenerDeFragment = (ListenerDeFragment) context;
    }

    @Override
    public void informarProductoSeleccionado(Resultado resultado) {
        listenerDeFragment.recibirProducto(resultado);
    }

    public interface ListenerDeFragment {
        public void recibirProducto(Resultado resultado);
    }
}