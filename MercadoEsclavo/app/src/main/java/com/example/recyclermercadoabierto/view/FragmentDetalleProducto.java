package com.example.recyclermercadoabierto.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.recyclermercadoabierto.R;
import com.example.recyclermercadoabierto.controller.ResultadoController;
import com.example.recyclermercadoabierto.model.Atributo;
import com.example.recyclermercadoabierto.model.Descripcion;
import com.example.recyclermercadoabierto.model.Resultado;
import com.example.recyclermercadoabierto.utils.ResultListener;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetalleProducto extends Fragment implements AdapterAtributos.ListenerDelAdapter  {

    public static final String CLAVE_PRODUCTO = "claveProducto";
    private RecyclerView recyclerView;
    private ListenerDeFragment listenerDeFragment;
    private TextView textViewNombre;
    private TextView textViewVendidos;
    private TextView textViewPrecio;
    private TextView textViewHayStock;
    private ImageView imageViewProducto;
    private TextView textViewDescripcion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

            View view = inflater.inflate(R.layout.fragment_detalle_producto, container, false);
            encontrarVistas(view);
            Bundle bundle = getArguments();
            Resultado resultadoSeleccionado =(Resultado)bundle.getSerializable(CLAVE_PRODUCTO);
            cargarProducto(view, resultadoSeleccionado);

            imageViewProducto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });



            return view;
    }

    private void hayStock(Resultado resultado){
        if(resultado.getAvailable_quantity()>0){
            textViewHayStock.setText("En stock");
            textViewHayStock.setTextColor(getResources().getColor(R.color.colorCinta));
        }else{
            textViewHayStock.setText("Agotado");
        }
    }

    private void mostrarAtributos(String unId){
        final AdapterAtributos adapterAtributos = new AdapterAtributos(this);
        final ResultadoController resultadoController = new ResultadoController();


        resultadoController.buscarAtributos(unId, new ResultListener<List<Atributo>>() {
            @Override
            public void finish(List<Atributo> results) {
                adapterAtributos.setAtributoList(results);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapterAtributos);
    }

    private void mostrarDescripcion(String unId){
        final ResultadoController resultadoController = new ResultadoController();

        resultadoController.buscarDescripcion(unId, new ResultListener<Descripcion>() {
            @Override
            public void finish(Descripcion results) {
                textViewDescripcion.setText(results.getPlain_text());
            }
        });

    }


    private void encontrarVistas(View view){
        recyclerView =view.findViewById(R.id.fragmentDetalleProducto_recyclerView);
        textViewNombre = view.findViewById(R.id.fragmentDetalleProducto_TextView_nombre);
        textViewVendidos = view.findViewById(R.id.fragmentDetalleProducto_TextView_vendidos);
        textViewPrecio = view.findViewById(R.id.fragmentDetalleProducto_TextView_precio);
        imageViewProducto = view.findViewById(R.id.fragmentDetalleProducto_ImageView_foto);
        textViewHayStock = view.findViewById(R.id.fragmentDetalleProducto_TextView_hayStock);
        textViewDescripcion = view.findViewById(R.id.fragmentDetalleProducto_TextView_descripcion);
    }

    private void cargarProducto(View view, Resultado unResultado){
        Glide.with(view)
                .load(unResultado.getImage_medium())
                .into(imageViewProducto);
        textViewNombre.setText(unResultado.getTitle());
        textViewPrecio.setText(unResultado.getPriceFormatted());
        hayStock(unResultado);
        textViewVendidos.setText(unResultado.getSold_quantity()+" vendidos");
        mostrarAtributos(unResultado.getId());
        mostrarDescripcion(unResultado.getId());

    }

    @Override
    public void informarAtributo(Atributo atributo) {
        listenerDeFragment.recibirAtributo(atributo);
    }

    public interface ListenerDeFragment {
        public void recibirAtributo(Atributo atributo);
    }
}
