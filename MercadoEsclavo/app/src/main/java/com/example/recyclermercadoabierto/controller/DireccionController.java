package com.example.recyclermercadoabierto.controller;

import com.example.recyclermercadoabierto.model.Direccion;
import com.example.recyclermercadoabierto.model.PedidosDao;
import com.example.recyclermercadoabierto.utils.ResultListener;

import java.util.List;

public class DireccionController {
    public void traerDireccion(final ResultListener listenerDeLaVista){
        PedidosDao pedidosDao = new PedidosDao();
        pedidosDao.traerDireccion(new ResultListener<List<Direccion>>() {
            @Override
            public void finish(List<Direccion> result) {
                listenerDeLaVista.finish(result);
            }
        });
    }
}
