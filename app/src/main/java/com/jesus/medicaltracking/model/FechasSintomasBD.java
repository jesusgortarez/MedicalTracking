package com.jesus.medicaltracking.model;

import com.jesus.medicaltracking.MainActivity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FechasSintomasBD extends RealmObject {
    @PrimaryKey
    private int id;
    private  String fecha;
    private String sintoma;

    public  FechasSintomasBD(){}

    public FechasSintomasBD(String fecha, String sintoma){
        id = MainActivity.FechasSintomasId.incrementAndGet();
        this.fecha = fecha;
        this.sintoma = sintoma;
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

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    @Override
    public String toString() {
        return getSintoma();
    }
}
