package com.example.recyclermercadoabierto.model;

import androidx.annotation.NonNull;

import java.util.List;

public class Atributo {
    private String id;
    private String value_name;
    private List<Value> values;
    private String attribute_group_id;
    private String attribute_group_name;
    private long source;
    private String name;
    private String value_id;
    private Object value_struct;

    public Atributo(String id, String value_name, List<Value> values, String attribute_group_id, String attribute_group_name, long source, String name, String value_id, Object value_struct) {
        this.id = id;
        this.value_name = value_name;
        this.values = values;
        this.attribute_group_id = attribute_group_id;
        this.attribute_group_name = attribute_group_name;
        this.source = source;
        this.name = name;
        this.value_id = value_id;
        this.value_struct = value_struct;
    }

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getValue_name() {
        return this.value_name;
    }
    public void setValue_name(String value_name) {
        this.value_name = value_name;
    }

    public List<Value> getValues() {
       return this.values;
   }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    public String getAttribute_group_id() {
        return this.attribute_group_id;
    }

    public void setAttribute_group_id(String attribute_group_id) {
        this.attribute_group_id = attribute_group_id;
    }

    public String getAttribute_group_name() {
        return this.attribute_group_name;
    }

    public void setAttribute_group_name(String attribute_group_name) {
        this.attribute_group_name = attribute_group_name;
    }

    public long getSource() {
        return this.source;
    }

    public void setSource(long source) {
        this.source = source;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue_id() {
        return this.value_id;
    }

    public void setValue_id(String value_id) {
        this.value_id = value_id;
    }

    public Object getValue_struct() {
        return this.value_struct;
    }
    public void setValue_struct(Object value_struct) {
        this.value_struct = value_struct;
    }


    @NonNull
    @Override
    public String toString() {
        return name+": "+value_name;
    }
}
