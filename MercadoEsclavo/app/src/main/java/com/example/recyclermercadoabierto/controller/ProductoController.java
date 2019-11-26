package com.example.recyclermercadoabierto.controller;

import com.example.recyclermercadoabierto.utils.ResultListener;
import com.example.recyclermercadoabierto.model.Producto;
import com.example.recyclermercadoabierto.model.PedidosDao;

import java.util.List;

public class ProductoController {

    public void buscarProductos(String unaPalabra, Integer limite, final ResultListener listenerDeLaVista){
        PedidosDao pedidosDao =new PedidosDao();
        pedidosDao.buscarProductos(unaPalabra, limite, new ResultListener<List<Producto>>() {
            @Override
            public void finish(List<Producto> results) {
                listenerDeLaVista.finish(results);
            }
        });

    }




}