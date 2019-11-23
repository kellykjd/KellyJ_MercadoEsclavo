package com.example.recyclermercadoabierto.controller;

import com.example.recyclermercadoabierto.model.PedidosDao;
import com.example.recyclermercadoabierto.model.Vendedor;
import com.example.recyclermercadoabierto.utils.ResultListener;

import java.util.List;

public class VendedorController {
    public void traerVendedor(final ResultListener listenerDeLaVista){
        PedidosDao pedidosDao = new PedidosDao();
        pedidosDao.traerVendedor(new ResultListener<List<Vendedor>>() {
            @Override
            public void finish(List<Vendedor> result) {
                listenerDeLaVista.finish(result);
            }
        });
    }
}