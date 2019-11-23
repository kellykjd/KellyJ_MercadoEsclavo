package com.example.recyclermercadoabierto.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/sites/MLA/search")
    Call<ContainerProductos> buscarPorPalabra(@Query("q") String unaPalabra);

}
