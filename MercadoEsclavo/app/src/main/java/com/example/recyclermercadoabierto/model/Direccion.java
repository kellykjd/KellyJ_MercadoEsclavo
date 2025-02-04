package com.example.recyclermercadoabierto.model;

public class Direccion {

    private String state_id;
    private String state_name;
    private String city_id;
    private String city_name;


    public Direccion(String state_id, String state_name, String city_id, String city_name) {
        this.state_id = state_id;
        this.state_name = state_name;
        this.city_id = city_id;
        this.city_name = city_name;
    }

    public Direccion() {
    }

    public String getState_id() {
        return state_id;
    }

    public void setState_id(String state_id) {
        this.state_id = state_id;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }
}
