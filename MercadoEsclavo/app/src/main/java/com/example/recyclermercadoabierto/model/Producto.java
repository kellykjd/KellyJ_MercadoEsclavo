package com.example.recyclermercadoabierto.model;

import java.io.Serializable;

//TODO: Eliminar los setters que no se usan

public class Producto implements Serializable {
    private String nombre;
    private String descripcion;
    private String precio;
    private Integer foto;

    public Producto(String nombre, String descripcion, String precio, Integer foto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Integer getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {
        this.foto = foto;
    }
}
