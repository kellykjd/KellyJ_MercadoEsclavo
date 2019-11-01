package com.example.recyclermercadoabierto.controller;

import com.example.recyclermercadoabierto.ResultListener;
import com.example.recyclermercadoabierto.model.Producto;
import com.example.recyclermercadoabierto.model.ProductoDao;

import java.util.List;

public class ProductoController {

    public void traerProductos(final ResultListener listenerDeLaVista){
        ProductoDao productoDao = new ProductoDao();
        productoDao.traerProductos(new ResultListener<List<Producto>>() {
            @Override
            public void finish(List<Producto> result) {
                listenerDeLaVista.finish(result);
            }
        });
    }
}
