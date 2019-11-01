package com.example.recyclermercadoabierto.view;

import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclermercadoabierto.R;
import com.example.recyclermercadoabierto.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class AdapterProductos extends RecyclerView.Adapter <AdapterProductos.ViewHolderProductos>{
//3er Paso
    private List<Producto> productoList;
    private ListenerDelAdapter listenerDelAdapter;

//4to Paso (2 constructores)
    public AdapterProductos(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public AdapterProductos(ListenerDelAdapter listenerDelAdapter) {
        productoList = new ArrayList<>();
        this.listenerDelAdapter = listenerDelAdapter;
    }

    //5to Paso
    @NonNull

    //5.4 Paso
    @Override
    public ViewHolderProductos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View vistaDeLaCelda = layoutInflater.inflate(R.layout.celda_producto,parent,false);
        return new ViewHolderProductos(vistaDeLaCelda);
    }

    //5.3 Paso
    @Override
    public void onBindViewHolder(@NonNull ViewHolderProductos holder, int position) {
        Producto productoMostrado = productoList.get(position);
        holder.cargarProducto(productoMostrado);
    }

    //5.1 Paso
    @Override
    public int getItemCount() {
        return productoList.size();
    }

//6to Paso
    public void setProductoList(List<Producto> productoList){
        this.productoList = productoList;
        notifyDataSetChanged();
    }

//2do paso
    public class ViewHolderProductos extends RecyclerView.ViewHolder{
        private TextView textViewNombre;
        private TextView textViewPrecio;
        private ImageView imageViewProducto;

    public ViewHolderProductos(@NonNull View itemView) {
        super(itemView);
        textViewNombre = itemView.findViewById(R.id.celdaProducto_TextView_nombre);
        textViewPrecio = itemView.findViewById(R.id.celdaProducto_TextView_precio);
        imageViewProducto = itemView.findViewById(R.id.celdaProducto_ImageView_foto);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Producto productoSeleccionado = productoList.get(getAdapterPosition());
                listenerDelAdapter.informarProductoSeleccionado(productoSeleccionado);
            }
        });
    }

    //5.2 Paso
    public void cargarProducto(Producto producto){
        textViewNombre.setText(producto.getNombre());
        textViewPrecio.setText(producto.getPrecio());
        imageViewProducto.setImageResource(producto.getFoto());
    }
}

//1er paso
    public interface ListenerDelAdapter{
        public void informarProductoSeleccionado(Producto producto);
    }
}
