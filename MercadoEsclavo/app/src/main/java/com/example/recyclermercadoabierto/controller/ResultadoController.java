package com.example.recyclermercadoabierto.controller;

import com.example.recyclermercadoabierto.model.Atributo;
import com.example.recyclermercadoabierto.model.Resultado;
import com.example.recyclermercadoabierto.utils.ResultListener;
import com.example.recyclermercadoabierto.model.PedidosDao;

import java.util.List;

public class ResultadoController {

    public void buscarProductos(String unaPalabra, Integer limite, final ResultListener listenerDeLaVista){
        PedidosDao pedidosDao =new PedidosDao();
        pedidosDao.buscarResultados(unaPalabra, limite, new ResultListener<List<Resultado>>() {
            @Override
            public void finish(List<Resultado> results) {
                listenerDeLaVista.finish(results);
            }
        });

    }

    public void buscarAtributos(String unId, final ResultListener listenerDeLaVista){
        PedidosDao pedidosDao =new PedidosDao();
        pedidosDao.buscarAtributos(unId, new ResultListener<List<Atributo>>() {
            @Override
            public void finish(List<Atributo> results) {
                listenerDeLaVista.finish(results);
            }
        });

    }


}