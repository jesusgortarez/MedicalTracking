package com.jesus.medicaltracking.model;

import com.jesus.medicaltracking.MainActivity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class AnimoBD extends RealmObject {
    @PrimaryKey
    private int id;
    private String nombre;

    public AnimoBD(){}

    public  AnimoBD(String nombre){
        id = MainActivity.AnimoId.incrementAndGet();
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString(){return getNombre();}
}
