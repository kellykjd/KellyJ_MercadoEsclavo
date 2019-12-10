package com.example.recyclermercadoabierto.model;

import java.io.Serializable;
import java.util.List;

public class Producto  implements Serializable {

    private String id;
    private String site_id;
    private String title;
    private Integer seller_id;
    private String category_id;
    private Integer price;
    private Integer base_price;
    private String currency_id;
    private Integer initial_quantity;
    private Integer available_quantity;
    private Integer sold_quantity;
    private String buying_mode;
    private String listing_type_id;
    private String condition;
    private String permalink;
    private String thumbnail;
    private String secure_thumbnail;
    private List<Foto> pictures;
    private Boolean accepts_mercadopago;
    private String international_delivery_mode;
    private List<Atributo> attributes;
    private String listing_source;
    private String status;
    private String warranty;
    private String catalog_product_id;
    private String domain_id;
    private Boolean automatic_relist;
    private Boolean catalog_listing;
    private List<Descripcion> descriptions;


    public Producto(String id, String site_id, String title, Integer seller_id, String category_id, Integer price, Integer base_price, String currency_id, Integer initial_quantity, Integer available_quantity, Integer sold_quantity, String buying_mode, String listing_type_id, String condition, String permalink, String thumbnail, String secure_thumbnail, List<Foto> pictures, Boolean accepts_mercadopago, String international_delivery_mode, List<Atributo> attributes, String listing_source, String status, String warranty, String catalog_product_id, String domain_id, Boolean automatic_relist, Boolean catalog_listing, List<Descripcion> descriptions) {
        this.id = id;
        this.site_id = site_id;
        this.title = title;
        this.seller_id = seller_id;
        this.category_id = category_id;
        this.price = price;
        this.base_price = base_price;
        this.currency_id = currency_id;
        this.initial_quantity = initial_quantity;
        this.available_quantity = available_quantity;
        this.sold_quantity = sold_quantity;
        this.buying_mode = buying_mode;
        this.listing_type_id = listing_type_id;
        this.condition = condition;
        this.permalink = permalink;
        this.thumbnail = thumbnail;
        this.secure_thumbnail = secure_thumbnail;
        this.pictures = pictures;
        this.accepts_mercadopago = accepts_mercadopago;
        this.international_delivery_mode = international_delivery_mode;
        this.attributes = attributes;
        this.listing_source = listing_source;
        this.status = status;
        this.warranty = warranty;
        this.catalog_product_id = catalog_product_id;
        this.domain_id = domain_id;
        this.automatic_relist = automatic_relist;
        this.catalog_listing = catalog_listing;
        this.descriptions = descriptions;
    }

    public Producto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Integer seller_id) {
        this.seller_id = seller_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getBase_price() {
        return base_price;
    }

    public void setBase_price(Integer base_price) {
        this.base_price = base_price;
    }

    public String getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(String currency_id) {
        this.currency_id = currency_id;
    }

    public Integer getInitial_quantity() {
        return initial_quantity;
    }

    public void setInitial_quantity(Integer initial_quantity) {
        this.initial_quantity = initial_quantity;
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

    public String getListing_type_id() {
        return listing_type_id;
    }

    public void setListing_type_id(String listing_type_id) {
        this.listing_type_id = listing_type_id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
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

    public String getSecure_thumbnail() {
        return secure_thumbnail;
    }

    public void setSecure_thumbnail(String secure_thumbnail) {
        this.secure_thumbnail = secure_thumbnail;
    }

    public List<Foto> getPictures() {
        return pictures;
    }

    public void setPictures(List<Foto> pictures) {
        this.pictures = pictures;
    }


    public Boolean getAccepts_mercadopago() {
        return accepts_mercadopago;
    }

    public void setAccepts_mercadopago(Boolean accepts_mercadopago) {
        this.accepts_mercadopago = accepts_mercadopago;
    }

    public String getInternational_delivery_mode() {
        return international_delivery_mode;
    }

    public void setInternational_delivery_mode(String international_delivery_mode) {
        this.international_delivery_mode = international_delivery_mode;
    }

    public List<Atributo> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Atributo> attributes) {
        this.attributes = attributes;
    }

    public String getListing_source() {
        return listing_source;
    }

    public void setListing_source(String listing_source) {
        this.listing_source = listing_source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getCatalog_product_id() {
        return catalog_product_id;
    }

    public void setCatalog_product_id(String catalog_product_id) {
        this.catalog_product_id = catalog_product_id;
    }

    public String getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(String domain_id) {
        this.domain_id = domain_id;
    }

    public Boolean getAutomatic_relist() {
        return automatic_relist;
    }

    public void setAutomatic_relist(Boolean automatic_relist) {
        this.automatic_relist = automatic_relist;
    }

    public Boolean getCatalog_listing() {
        return catalog_listing;
    }

    public void setCatalog_listing(Boolean catalog_listing) {
        this.catalog_listing = catalog_listing;
    }

    public List<Descripcion> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Descripcion> descriptions) {
        this.descriptions = descriptions;
    }
}
