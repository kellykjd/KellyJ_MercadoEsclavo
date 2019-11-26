package com.example.recyclermercadoabierto.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclermercadoabierto.R;
import com.example.recyclermercadoabierto.model.Resultado;

import java.util.ArrayList;
import java.util.List;

public class AdapterProductos extends RecyclerView.Adapter <AdapterProductos.ViewHolderProductos>{
//3er Paso
    private List<Resultado> resultadoList;
    private ListenerDelAdapter listenerDelAdapter;

//4to Paso (2 constructores)
    public AdapterProductos(List<Resultado> resultadoList) {
        this.resultadoList = resultadoList;
    }

    public AdapterProductos(ListenerDelAdapter listenerDelAdapter) {
        resultadoList = new ArrayList<>();
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
        Resultado resultadoMostrado = resultadoList.get(position);
        holder.cargarProducto(resultadoMostrado);
    }


    @Override
    public int getItemCount() {
        return resultadoList.size();
    }


    public void setResultadoList(List<Resultado> resultadoList){
        this.resultadoList = resultadoList;
        notifyDataSetChanged();
    }

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
                Resultado resultadoSeleccionado = resultadoList.get(getAdapterPosition());
                listenerDelAdapter.informarProductoSeleccionado(resultadoSeleccionado);
            }
        });
    }

    public void cargarProducto(Resultado resultado){
        textViewNombre.setText(resultado.getTitle());
        textViewPrecio.setText(resultado.getPriceFormatted());

        Glide.with(itemView)
                .load(resultado.getThumbnail())
                .into(imageViewProducto);

    }
}
    public interface ListenerDelAdapter{
        public void informarProductoSeleccionado(Resultado resultado);
    }
}
