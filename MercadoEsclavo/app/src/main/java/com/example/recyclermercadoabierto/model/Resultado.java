package com.example.recyclermercadoabierto.model;


import androidx.annotation.NonNull;

import java.io.Serializable;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//TODO: Eliminar los setters que no se usan

public class Resultado implements Serializable {
    private String id;
    //private String site_id;
    private String title;
    private Vendedor seller;
    private Double price;
    private String currency_id;
    private Integer available_quantity;
    private Integer sold_quantity;
    private String buying_mode;
    //private String listing_type_id;
    // private Date stop_time;
    private String condition;
    private String permalink;
    private String thumbnail;
    // private Boolean accepts_mercadopago;
    //public Installments installments;
    private Direccion address;
    //public Shipping shipping;
    //public SellerAddress seller_address;
    private List<Atributo> attributes;
    private Integer original_price;
    private String category_id;
    //   private Integer official_store_id;
    // private Object catalog_product_id;
    private List<String> tags;
    private String image_medium;




    public Resultado(String id, String title, Vendedor seller, Double price, String currency_id, Integer available_quantity, Integer sold_quantity, String buying_mode, String permalink, String thumbnail, Direccion address, Integer original_price, String category_id, List<String> tags, String image_medium, String condition, List<Atributo> attributes) {
        this.id = id;
        this.title = title;
        this.seller = seller;
        this.price = price;
        this.currency_id = currency_id;
        this.available_quantity = available_quantity;
        this.sold_quantity = sold_quantity;
        this.buying_mode = buying_mode;
        this.permalink = permalink;
        this.thumbnail = thumbnail;

        this.address = address;
        this.original_price = original_price;
        this.category_id = category_id;
        this.tags = tags;
        this.image_medium = image_medium;
        this.condition = condition;
        this.attributes = attributes;
    }

    public Resultado() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Vendedor getSeller() {
        return seller;
    }

    public void setSeller(Vendedor seller) {
        this.seller = seller;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPriceFormatted(){

        String str = String.format("%,d", ((int) Math.round(this.getPrice())));

        String priceFormatted = this.getCurrency_id()+" "+str;

        return priceFormatted;
    }

    public String getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(String currency_id) {
        this.currency_id = currency_id;
    }

    public Integer getAvailable_quantity() {
        return available_quantity;
    }

    public void setAvailable_quantity(Integer available_quantity) {
        this.available_quantity = available_quantity;
    }

    public Integer getSold_quantity() {
        return sold_quantity;
    }

    public void setSold_quantity(Integer sold_quantity) {
        this.sold_quantity = sold_quantity;
    }

    public String getBuying_mode() {
        return buying_mode;
    }

    public void setBuying_mode(String buying_mode) {
        this.buying_mode = buying_mode;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Direccion getAddress() {
        return address;
    }

    public void setAddress(Direccion address) {
        this.address = address;
    }

    public Integer getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(Integer original_price) {
        this.original_price = original_price;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getImage_medium() {

        String texto= this.thumbnail;
        int n1 = this.thumbnail.length()-4;
        String image_medium = texto.substring(0,n1-1)+'B'+texto.substring(n1);


        return image_medium;
    }

    public void setImage_medium(String image_medium) {
        this.image_medium = image_medium;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public List<Atributo> getAttributes() {
        return this.attributes;
    }

    public void setAttributes(List<Atributo> attributes) {
        this.attributes = attributes;
    }

}



