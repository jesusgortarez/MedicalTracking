package com.jesus.medicaltracking.model;

import com.jesus.medicaltracking.MainActivity;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FechasAnimoBD extends RealmObject {
    @PrimaryKey
    private int id;

    private  String fecha;
    private String animo;

    public  FechasAnimoBD(){}

    public FechasAnimoBD(String fecha, String animo){
        id = MainActivity.FechasId.incrementAndGet();
        this.fecha = fecha;
        this.animo = animo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAnimo() {
        return animo;
    }

    public void getAnimo(String animo) {
        this.animo = animo;
    }

    @Override
    public String toString() {
        return getAnimo();
    }


}
