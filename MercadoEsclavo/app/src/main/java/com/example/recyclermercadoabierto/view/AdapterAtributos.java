package com.example.recyclermercadoabierto.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclermercadoabierto.R;
import com.example.recyclermercadoabierto.model.Atributo;

import java.util.ArrayList;
import java.util.List;

public class AdapterAtributos extends RecyclerView.Adapter <AdapterAtributos.ViewHolderAtributos>{
//3er Paso
        private List<Atributo> atributoList;
        private ListenerDelAdapter listenerDelAdapter;

//4to Paso (2 constructores)
    public AdapterAtributos(List<Atributo> atributotoList) {
            this.atributoList = atributoList;
        }

    public AdapterAtributos(ListenerDelAdapter listenerDelAdapter) {
            atributoList = new ArrayList<>();
            this.listenerDelAdapter = listenerDelAdapter;
        }

        //5to Paso
        @NonNull
        //5.4 Paso
        @Override
        public ViewHolderAtributos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View vistaDeLaCelda = layoutInflater.inflate(R.layout.celda_aributo,parent,false);
            return new ViewHolderAtributos(vistaDeLaCelda);
        }

        //5.3 Paso
        @Override
        public void onBindViewHolder(@NonNull ViewHolderAtributos holder, int position) {
            Atributo atributoMostrado = atributoList.get(position);
            holder.cargarAtributo(atributoMostrado);
        }


        @Override
        public int getItemCount() {
            return atributoList.size();
        }


        public void setAtributoList(List<Atributo> atributoList){
            this.atributoList = atributoList;
            notifyDataSetChanged();
        }

        public class ViewHolderAtributos extends RecyclerView.ViewHolder{
            private TextView textViewNombreAtributo;
            private TextView textViewDescripcionAtributo;

            public ViewHolderAtributos(@NonNull View itemView) {
                super(itemView);
                textViewNombreAtributo = itemView.findViewById(R.id.celdaAtributo_textView_nombreAtributo);
                textViewDescripcionAtributo = itemView.findViewById(R.id.celdaAtributo_textView_descripcionAtributo);
            }

            public void cargarAtributo(Atributo atributo){
                textViewNombreAtributo.setText(atributo.getName());
                textViewDescripcionAtributo.setText(atributo.getValue_name());
            }
        }
        public interface ListenerDelAdapter{
            public void informarAtributo(Atributo atributo);
        }

}
