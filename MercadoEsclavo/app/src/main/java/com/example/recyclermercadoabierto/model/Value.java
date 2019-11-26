package com.example.recyclermercadoabierto.model;

public class Value {
    private String id;
    private String name;
    private Object struct;
    private long source;

    public Value(String id, String name, Object struct, long source) {
        this.id = id;
        this.name = name;
        this.struct = struct;
        this.source = source;
    }

    private String getId() {
        return this.id;
    }

    private void setId(String id) {
        this.id = id;
    }

    private String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private Object getStruct() {
        return this.struct;
    }

    private void setStruct(Object struct) {
        this.struct = struct;
    }

    private long getSource() {
        return this.source;
    }
    private void setSource(long source) {
        this.source = source;
    }

}
