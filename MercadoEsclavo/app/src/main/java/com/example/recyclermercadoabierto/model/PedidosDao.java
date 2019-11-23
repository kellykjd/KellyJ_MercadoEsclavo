package com.example.recyclermercadoabierto.model;

import android.util.Log;

import com.example.recyclermercadoabierto.utils.ResultListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PedidosDao extends PedidosRetrofitDao {

    public static final String BASE_URL="https://api.mercadolibre.com/";
    public PedidosDao (){
        super(BASE_URL);
    }

    public void buscarProductos(String unaPalabra, final ResultListener<List<Producto>> listenerDelController){
        Call<ContainerProductos> call =apiService.buscarPorPalabra(unaPalabra);

        call.enqueue(new Callback<ContainerProductos>() {
            @Override
            public void onResponse(Call<ContainerProductos> call, Response<ContainerProductos> response) {
                ContainerProductos containerProductos =response.body();
                listenerDelController.finish(containerProductos.getResults());
            }

            @Override
            public void onFailure(Call<ContainerProductos> call, Throwable t) {
                Log.d("Pedido", "Fallas con el pedido, revisar");
            }
        });

    }

    public void traerDireccion(ResultListener<List<Direccion>> listenerDelController){


    }

    public void traerVendedor(ResultListener<List<Vendedor>> listenerDelController){


    }
}
