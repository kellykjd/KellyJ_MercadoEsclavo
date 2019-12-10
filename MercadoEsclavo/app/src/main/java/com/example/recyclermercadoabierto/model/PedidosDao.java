package com.example.recyclermercadoabierto.model;

import android.util.Log;

import com.example.recyclermercadoabierto.utils.ResultListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PedidosDao extends PedidosRetrofitDao {

    public static final String BASE_URL = "https://api.mercadolibre.com/";

    public PedidosDao() {
        super(BASE_URL);
    }

    public void buscarResultados(String unaPalabra, Integer limite, final ResultListener<List<Resultado>> listenerDelController) {
        Call<ContainerResultado> call = apiService.buscarPorPalabra(unaPalabra, limite);

        call.enqueue(new Callback<ContainerResultado>() {
            @Override
            public void onResponse(Call<ContainerResultado> call, Response<ContainerResultado> response) {
                ContainerResultado containerResultado = response.body();
                listenerDelController.finish(containerResultado.getResults());
            }

            @Override
            public void onFailure(Call<ContainerResultado> call, Throwable t) {

                Log.d("RESULTS", "Fallas con el pedido, revisar");
            }
        });

    }

    public void buscarAtributos(String unId, final ResultListener<List<Atributo>> listenerDelController) {
        Call<Resultado> call = apiService.traerAtributos(unId);

        call.enqueue(new Callback<Resultado>() {
            @Override
            public void onResponse(Call<Resultado> call, Response<Resultado> response) {
                Resultado unResultado = response.body();
                listenerDelController.finish(unResultado.getAttributes());
            }

            @Override
            public void onFailure(Call<Resultado> call, Throwable t) {

                Log.d("ATRIBUTO", "Fallas con el pedido, revisar");
            }
        });

    }

    public void traerDescripcion(String unId, final ResultListener<Descripcion> listenerDelController) {
        Call<List<Descripcion>> call = apiService.traerDescripcionItem(unId);

        call.enqueue(new Callback<List<Descripcion>>() {
    @Override
    public void onResponse(Call<List<Descripcion>> call, Response<List<Descripcion>> response) {
        Descripcion unaDescripcion = response.body().get(0);
        listenerDelController.finish(unaDescripcion);
    }

    @Override
    public void onFailure(Call<List<Descripcion>> call, Throwable t) {

    }
});
    }


}
