package com.example.recyclermercadoabierto.model;

import java.util.List;

public class Producto {
/*
    public String getId() {
        return this.id
    }
    public String setId(String id) {
        this.id = id
    }
    String id;


    public String getSite_id() {
        return this.site_id
    }
    public String setSite_id(String site_id) {
        this.site_id = site_id
    }
    String site_id;


    public String getTitle() {
        return this.title
    }
    public String setTitle(String title) {
        this.title = title
    }
    String title;


    public object getSubtitle() {
        return this.subtitle
    }
    public object setSubtitle(object subtitle) {
        this.subtitle = subtitle
    }
    object subtitle;


    public int getSeller_id() {
        return this.seller_id
    }
    public int setSeller_id(int seller_id) {
        this.seller_id = seller_id
    }
    int seller_id;


    public String getCategory_id() {
        return this.category_id
    }
    public String setCategory_id(String category_id) {
        this.category_id = category_id
    }
    String category_id;


    public object getOfficial_store_id() {
        return this.official_store_id
    }
    public object setOfficial_store_id(object official_store_id) {
        this.official_store_id = official_store_id
    }
    object official_store_id;


    public int getPrice() {
        return this.price
    }
    public int setPrice(int price) {
        this.price = price
    }
    int price;


    public int getBase_price() {
        return this.base_price
    }
    public int setBase_price(int base_price) {
        this.base_price = base_price
    }
    int base_price;


    public object getOriginal_price() {
        return this.original_price
    }
    public object setOriginal_price(object original_price) {
        this.original_price = original_price
    }
    object original_price;


    public String getCurrency_id() {
        return this.currency_id
    }
    public String setCurrency_id(String currency_id) {
        this.currency_id = currency_id
    }
    String currency_id;


    public int getInitial_quantity() {
        return this.initial_quantity
    }
    public int setInitial_quantity(int initial_quantity) {
        this.initial_quantity = initial_quantity
    }
    int initial_quantity;


    public int getAvailable_quantity() {
        return this.available_quantity
    }
    public int setAvailable_quantity(int available_quantity) {
        this.available_quantity = available_quantity
    }
    int available_quantity;


    public int getSold_quantity() {
        return this.sold_quantity
    }
    public int setSold_quantity(int sold_quantity) {
        this.sold_quantity = sold_quantity
    }
    int sold_quantity;


    public List<SaleTerm> getSale_terms() {
        return this.sale_terms
    }
    public List<SaleTerm> setSale_terms(List<SaleTerm> sale_terms) {
        this.sale_terms = sale_terms
    }
    List<SaleTerm> sale_terms;


    public String getBuying_mode() {
        return this.buying_mode
    }
    public String setBuying_mode(String buying_mode) {
        this.buying_mode = buying_mode
    }
    String buying_mode;


    public String getListing_type_id() {
        return this.listing_type_id
    }
    public String setListing_type_id(String listing_type_id) {
        this.listing_type_id = listing_type_id
    }
    String listing_type_id;


    public Date getStart_time() {
        return this.start_time
    }
    public Date setStart_time(Date start_time) {
        this.start_time = start_time
    }
    Date start_time;


    public Date getStop_time() {
        return this.stop_time
    }
    public Date setStop_time(Date stop_time) {
        this.stop_time = stop_time
    }
    Date stop_time;


    public String getCondition() {
        return this.condition
    }
    public String setCondition(String condition) {
        this.condition = condition
    }
    String condition;


    public String getPermalink() {
        return this.permalink
    }
    public String setPermalink(String permalink) {
        this.permalink = permalink
    }
    String permalink;


    public List<Picture> getPictures() {
        return this.pictures
    }
    public List<Picture> setPictures(List<Picture> pictures) {
        this.pictures = pictures
    }
    List<Picture> pictures;


    public object getVideo_id() {
        return this.video_id
    }
    public object setVideo_id(object video_id) {
        this.video_id = video_id
    }
    object video_id;


    public List<Description> getDescriptions() {
        return this.descriptions
    }
    public List<Description> setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions
    }
    List<Description> descriptions;


    public boolean getAccepts_mercadopago() {
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
    List<Object> non_mercado_pago_payment_methods;


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
    }*/
}
