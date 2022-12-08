package com.jesus.medicaltracking;

public class ListAcercaDe {

    int id;
    String name;
    String data;

    public ListAcercaDe(int id, String name, String data) {
        this.id = id;
        this.name = name;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String datos() {
        return getData();
    }

    public String nombre() {
        return getName();
    }

}