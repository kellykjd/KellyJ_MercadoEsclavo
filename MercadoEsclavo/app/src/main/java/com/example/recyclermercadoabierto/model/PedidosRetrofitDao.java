package com.example.recyclermercadoabierto.model;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PedidosRetrofitDao{

        private Retrofit retrofit;
        protected ApiService apiService;


        public PedidosRetrofitDao(String baseURL) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiService = retrofit.create(ApiService.class);
        }
}
