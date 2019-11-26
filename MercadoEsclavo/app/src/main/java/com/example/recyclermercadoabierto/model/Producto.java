package com.example.recyclermercadoabierto.model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

//TODO: Eliminar los setters que no se usan

public class Producto implements Serializable {
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
    //private String condition;
    private String permalink;
    private String thumbnail;
    // private Boolean accepts_mercadopago;
    //public Installments installments;
    private Direccion address;
    //public Shipping shipping;
    //public SellerAddress seller_address;
    //  private List<KeyStore.Entry.Attribute> attributes;
    private Integer original_price;
    private String category_id;
    //   private Integer official_store_id;
    // private Object catalog_product_id;
    private List<String> tags;
    private String image_medium;




    public Producto(String id, String title, Vendedor seller, Double price, String currency_id, Integer available_quantity, Integer sold_quantity, String buying_mode, String permalink, String thumbnail, Direccion address, Integer original_price, String category_id, List<String> tags, String image_medium) {
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
    }

    public Producto() {
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

/*

    public String id;
    public String site_id;
    public String title;
    public Object subtitle;
    public Integer seller_id;
    public String category_id;
    public Object official_store_id;
    public Integer price;
    public Integer base_price;
    public Object original_price;
    public String currency_id;
    public Integer initial_quantity;
    public Integer available_quantity;
    public Integer sold_quantity;
    public List<Object> sale_terms;
    public String buying_mode;
    public String listing_type_id;
    public Date start_time;
    public Date stop_time;
    public String condition;
    public String permalink;
    public List<Object> pictures;
    public Object video_id;
    public List<Object> descriptions;
    public Boolean accepts_mercadopago;
    public List<Object> non_mercado_pago_payment_methods;
    //public Shipping shipping;
    public String international_delivery_mode;
   // public SellerAddress seller_address;
    public Object seller_contact;
    //public Location location;
    //public Geolocation geolocation;
    public List<Object> coverage_areas;
    public List<Object> attributes;
    public List<Object> warnings;
    public String listing_source;
    public List<Object> variations;
    public String thumbnail;
    public String secure_thumbnail;
    public String status;
    public List<Object> sub_status;
    public List<Object> tags;
    public String warranty;
    public String catalog_product_id;
    public String domain_id;
    public Object parent_item_id;
    public Object differential_pricing;
    public List<Object> deal_ids;
    public Boolean automatic_relist;
    public Date date_created;
    public Date last_updated;
    public Object health;
    public Boolean catalog_listing;
    private String image_medium;

    public Producto(String id, String site_id, String title, Object subtitle, Integer seller_id, String category_id, Object official_store_id, Integer price, Integer base_price, Object original_price, String currency_id, Integer initial_quantity, Integer available_quantity, Integer sold_quantity, List<Object> sale_terms, String buying_mode, String listing_type_id, Date start_time, Date stop_time, String condition, String permalink, List<Object> pictures, Object video_id, List<Object> descriptions, Boolean accepts_mercadopago, List<Object> non_mercado_pago_payment_methods, String international_delivery_mode, Object seller_contact, List<Object> coverage_areas, List<Object> attributes, List<Object> warnings, String listing_source, List<Object> variations, String thumbnail, String secure_thumbnail, String status, List<Object> sub_status, List<Object> tags, String warranty, String catalog_product_id, String domain_id, Object parent_item_id, Object differential_pricing, List<Object> deal_ids, Boolean automatic_relist, Date date_created, Date last_updated, Object health, Boolean catalog_listing, String image_medium) {
        this.id = id;
        this.site_id = site_id;
        this.title = title;
        this.subtitle = subtitle;
        this.seller_id = seller_id;
        this.category_id = category_id;
        this.official_store_id = official_store_id;
        this.price = price;
        this.base_price = base_price;
        this.original_price = original_price;
        this.currency_id = currency_id;
        this.initial_quantity = initial_quantity;
        this.available_quantity = available_quantity;
        this.sold_quantity = sold_quantity;
        this.sale_terms = sale_terms;
        this.buying_mode = buying_mode;
        this.listing_type_id = listing_type_id;
        this.start_time = start_time;
        this.stop_time = stop_time;
        this.condition = condition;
        this.permalink = permalink;
        this.pictures = pictures;
        this.video_id = video_id;
        this.descriptions = descriptions;
        this.accepts_mercadopago = accepts_mercadopago;
        this.non_mercado_pago_payment_methods = non_mercado_pago_payment_methods;
        this.international_delivery_mode = international_delivery_mode;
        this.seller_contact = seller_contact;
        this.coverage_areas = coverage_areas;
        this.attributes = attributes;
        this.warnings = warnings;
        this.listing_source = listing_source;
        this.variations = variations;
        this.thumbnail = thumbnail;
        this.secure_thumbnail = secure_thumbnail;
        this.status = status;
        this.sub_status = sub_status;
        this.tags = tags;
        this.warranty = warranty;
        this.catalog_product_id = catalog_product_id;
        this.domain_id = domain_id;
        this.parent_item_id = parent_item_id;
        this.differential_pricing = differential_pricing;
        this.deal_ids = deal_ids;
        this.automatic_relist = automatic_relist;
        this.date_created = date_created;
        this.last_updated = last_updated;
        this.health = health;
        this.catalog_listing = catalog_listing;
        this.image_medium = image_medium;
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

    public Object getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(Object subtitle) {
        this.subtitle = subtitle;
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

    public Object getOfficial_store_id() {
        return official_store_id;
    }

    public void setOfficial_store_id(Object official_store_id) {
        this.official_store_id = official_store_id;
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

    public Object getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(Object original_price) {
        this.original_price = original_price;
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

    public List<Object> getSale_terms() {
        return sale_terms;
    }

    public void setSale_terms(List<Object> sale_terms) {
        this.sale_terms = sale_terms;
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

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getStop_time() {
        return stop_time;
    }

    public void setStop_time(Date stop_time) {
        this.stop_time = stop_time;
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

    public List<Object> getPictures() {
        return pictures;
    }

    public void setPictures(List<Object> pictures) {
        this.pictures = pictures;
    }

    public Object getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Object video_id) {
        this.video_id = video_id;
    }

    public List<Object> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Object> descriptions) {
        this.descriptions = descriptions;
    }

    public Boolean getAccepts_mercadopago() {
        return accepts_mercadopago;
    }

    public void setAccepts_mercadopago(Boolean accepts_mercadopago) {
        this.accepts_mercadopago = accepts_mercadopago;
    }

    public List<Object> getNon_mercado_pago_payment_methods() {
        return non_mercado_pago_payment_methods;
    }

    public void setNon_mercado_pago_payment_methods(List<Object> non_mercado_pago_payment_methods) {
        this.non_mercado_pago_payment_methods = non_mercado_pago_payment_methods;
    }

    public String getInternational_delivery_mode() {
        return international_delivery_mode;
    }

    public void setInternational_delivery_mode(String international_delivery_mode) {
        this.international_delivery_mode = international_delivery_mode;
    }

    public Object getSeller_contact() {
        return seller_contact;
    }

    public void setSeller_contact(Object seller_contact) {
        this.seller_contact = seller_contact;
    }

    public List<Object> getCoverage_areas() {
        return coverage_areas;
    }

    public void setCoverage_areas(List<Object> coverage_areas) {
        this.coverage_areas = coverage_areas;
    }

    public List<Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Object> attributes) {
        this.attributes = attributes;
    }

    public List<Object> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<Object> warnings) {
        this.warnings = warnings;
    }

    public String getListing_source() {
        return listing_source;
    }

    public void setListing_source(String listing_source) {
        this.listing_source = listing_source;
    }

    public List<Object> getVariations() {
        return variations;
    }

    public void setVariations(List<Object> variations) {
        this.variations = variations;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Object> getSub_status() {
        return sub_status;
    }

    public void setSub_status(List<Object> sub_status) {
        this.sub_status = sub_status;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
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

    public Object getParent_item_id() {
        return parent_item_id;
    }

    public void setParent_item_id(Object parent_item_id) {
        this.parent_item_id = parent_item_id;
    }

    public Object getDifferential_pricing() {
        return differential_pricing;
    }

    public void setDifferential_pricing(Object differential_pricing) {
        this.differential_pricing = differential_pricing;
    }

    public List<Object> getDeal_ids() {
        return deal_ids;
    }

    public void setDeal_ids(List<Object> deal_ids) {
        this.deal_ids = deal_ids;
    }

    public Boolean getAutomatic_relist() {
        return automatic_relist;
    }

    public void setAutomatic_relist(Boolean automatic_relist) {
        this.automatic_relist = automatic_relist;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(Date last_updated) {
        this.last_updated = last_updated;
    }

    public Object getHealth() {
        return health;
    }

    public void setHealth(Object health) {
        this.health = health;
    }

    public Boolean getCatalog_listing() {
        return catalog_listing;
    }

    public void setCatalog_listing(Boolean catalog_listing) {
        this.catalog_listing = catalog_listing;
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
*/





}



