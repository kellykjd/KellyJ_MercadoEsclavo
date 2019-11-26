package com.example.recyclermercadoabierto.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    //buscar por palabra con límite de productos
    @GET("/sites/MLA/search")
    Call<ContainerResultado> buscarPorPalabra(@Query("q") String unaPalabra, @Query ("limit")Integer limite);

/*    //buscar descripcion de producto
    @GET("/items/{id}/descriptions")
    Call<Informacion> traerDescripcionItem(@Path("id") String idItem);*/

    @GET("/items/{id}")
    Call<Resultado> traerAtributos(@Path("id") String idItem);

}
