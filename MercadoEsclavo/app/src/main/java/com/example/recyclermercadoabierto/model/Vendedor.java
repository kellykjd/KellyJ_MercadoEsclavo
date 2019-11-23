package com.example.recyclermercadoabierto.model;

import java.util.List;

public class Vendedor {
    private Integer id;
    private Object permalink;
    private String power_seller_status;
    private Boolean car_dealer;
    private Boolean real_estate_agency;
    private List<Object> tags;

    public Vendedor(Integer id, Object permalink, String power_seller_status, Boolean car_dealer, Boolean real_estate_agency, List<Object> tags) {
        this.id = id;
        this.permalink = permalink;
        this.power_seller_status = power_seller_status;
        this.car_dealer = car_dealer;
        this.real_estate_agency = real_estate_agency;
        this.tags = tags;
    }

    public Vendedor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getPermalink() {
        return permalink;
    }

    public void setPermalink(Object permalink) {
        this.permalink = permalink;
    }

    public String getPower_seller_status() {
        return power_seller_status;
    }

    public void setPower_seller_status(String power_seller_status) {
        this.power_seller_status = power_seller_status;
    }

    public Boolean getCar_dealer() {
        return car_dealer;
    }

    public void setCar_dealer(Boolean car_dealer) {
        this.car_dealer = car_dealer;
    }

    public Boolean getReal_estate_agency() {
        return real_estate_agency;
    }

    public void setReal_estate_agency(Boolean real_estate_agency) {
        this.real_estate_agency = real_estate_agency;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }
}
