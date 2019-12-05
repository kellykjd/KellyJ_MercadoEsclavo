package com.example.recyclermercadoabierto.model;


import android.util.EventLogTags;

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




/*
    String id;
    String site_id;
    String title;
    //object subtitle;
    Integer seller_id;
    String category_id;
    //object official_store_id;
    //object original_price;
    Integer price;
    Integer base_price;
    String currency_id;
    Integer initial_quantity;
    Integer available_quantity;
    Integer sold_quantity;
    //List<SaleTerm> sale_terms;
    String buying_mode;
    String listing_type_id;
    Date start_time;
    Date stop_time;
    String condition;
    String permalink;
    List<Descripcion> descriptions;








    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSite_id() {
        return this.site_id;
    }
    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSeller_id() {
        return this.seller_id;
    }

    public void setSeller_id(Integer seller_id) {
        this.seller_id = seller_id;
    }

    public String getCategory_id() {
        return this.category_id;
    }
    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public Integer getPrice() {
        return this.price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getBase_price() {
        return this.base_price;
    }
    public void setBase_price(int base_price) {
        this.base_price = base_price;
    }

    public String getCurrency_id() {
        return this.currency_id;
    }
    public void setCurrency_id(String currency_id) {
        this.currency_id = currency_id;
    }

    public Integer getInitial_quantity() {
        return this.initial_quantity;
    }
    public void setInitial_quantity(Integer initial_quantity) {
        this.initial_quantity = initial_quantity;
    }

    public Integer getAvailable_quantity() {
        return this.available_quantity;
    }
    public void setAvailable_quantity(Integer available_quantity) {
        this.available_quantity = available_quantity;
    }

    public Integer getSold_quantity() {
        return this.sold_quantity;
    }
    public void setSold_quantity(Integer sold_quantity) {
        this.sold_quantity = sold_quantity;
    }

    public String getBuying_mode() {
        return this.buying_mode;
    }
    public void setBuying_mode(String buying_mode) {
        this.buying_mode = buying_mode;
    }

    public String getListing_type_id() {
        return this.listing_type_id;
    }
    public void setListing_type_id(String listing_type_id) {
        this.listing_type_id = listing_type_id;
    }

    public Date getStart_time() {
        return this.start_time;
    }
    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getStop_time() {
        return this.stop_time;
    }
    public void setStop_time(Date stop_time) {
        this.stop_time = stop_time;
    }

    public String getCondition() {
        return this.condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPermalink() {
        return this.permalink;
    }
    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

*/
/*    public List<Picture> getPictures() {
        return this.pictures
    }
    public List<Picture> setPictures(List<Picture> pictures) {
        this.pictures = pictures
    }
    List<Picture> pictures;*//*


*/
/*    public object getVideo_id() {
        return this.video_id
    }
    public object setVideo_id(object video_id) {
        this.video_id = video_id
    }
    object video_id;*//*



    public List<Descripcion> getDescriptions() {
        return this.descriptions;
    }
    public void setDescriptions(List<Descripcion> descriptions) {
        this.descriptions = descriptions;
    }


*/
/*    public boolean getAccepts_mercadopago() {
        return this.accepts_mercadopago
    }
    public boolean setAccepts_mercadopago(boolean accepts_mercadopago) {
        this.accepts_mercadopago = accepts_mercadopago
    }
    boolean accepts_mercadopago;


    public List<Object> getNon_mercado_pago_payment_methods() {
        return this.non_mercado_pago_payment_methods
    }
    public List<Object> setNon_mercado_pago_payment_methods(List<Object> non_mercado_pago_payment_methods) {
        this.non_mercado_pago_payment_methods = non_mercado_pago_payment_methods
    }
    List<Object> non_mercado_pago_payment_methods;*//*



    public Shipping getShipping() {
        return this.shipping
    }
    public Shipping setShipping(Shipping shipping) {
        this.shipping = shipping
    }
    Shipping shipping;


    public String getInternational_delivery_mode() {
        return this.international_delivery_mode
    }
    public String setInternational_delivery_mode(String international_delivery_mode) {
        this.international_delivery_mode = international_delivery_mode
    }
    String international_delivery_mode;


    public SellerAddress getSeller_address() {
        return this.seller_address
    }
    public SellerAddress setSeller_address(SellerAddress seller_address) {
        this.seller_address = seller_address
    }
    SellerAddress seller_address;


    public object getSeller_contact() {
        return this.seller_contact
    }
    public object setSeller_contact(object seller_contact) {
        this.seller_contact = seller_contact
    }
    object seller_contact;

    @JsonProperty("location")
    public Location getLocation() {
        return this.location
    }
    public Location setLocation(Location location) {
        this.location = location
    }
    Location location;

    @JsonProperty("geolocation")
    public Geolocation getGeolocation() {
        return this.geolocation
    }
    public Geolocation setGeolocation(Geolocation geolocation) {
        this.geolocation = geolocation
    }
    Geolocation geolocation;

    @JsonProperty("coverage_areas")
    public List<Object> getCoverage_areas() {
        return this.coverage_areas
    }
    public List<Object> setCoverage_areas(List<Object> coverage_areas) {
        this.coverage_areas = coverage_areas
    }
    List<Object> coverage_areas;

    @JsonProperty("attributes")
    public List<Attribute> getAttributes() {
        return this.attributes
    }
    public List<Attribute> setAttributes(List<Attribute> attributes) {
        this.attributes = attributes
    }
    List<Attribute> attributes;

    @JsonProperty("warnings")
    public List<Object> getWarnings() {
        return this.warnings
    }
    public List<Object> setWarnings(List<Object> warnings) {
        this.warnings = warnings
    }
    List<Object> warnings;

    @JsonProperty("listing_source")
    public String getListing_source() {
        return this.listing_source
    }
    public String setListing_source(String listing_source) {
        this.listing_source = listing_source
    }
    String listing_source;

    @JsonProperty("variations")
    public List<Object> getVariations() {
        return this.variations
    }
    public List<Object> setVariations(List<Object> variations) {
        this.variations = variations
    }
    List<Object> variations;

    @JsonProperty("thumbnail")
    public String getThumbnail() {
        return this.thumbnail
    }
    public String setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail
    }
    String thumbnail;

    @JsonProperty("secure_thumbnail")
    public String getSecure_thumbnail() {
        return this.secure_thumbnail
    }
    public String setSecure_thumbnail(String secure_thumbnail) {
        this.secure_thumbnail = secure_thumbnail
    }
    String secure_thumbnail;

    @JsonProperty("status")
    public String getStatus() {
        return this.status
    }
    public String setStatus(String status) {
        this.status = status
    }
    String status;

    @JsonProperty("sub_status")
    public List<Object> getSub_status() {
        return this.sub_status
    }
    public List<Object> setSub_status(List<Object> sub_status) {
        this.sub_status = sub_status
    }
    List<Object> sub_status;

    @JsonProperty("tags")
    public List<String> getTags() {
        return this.tags
    }
*/



}



