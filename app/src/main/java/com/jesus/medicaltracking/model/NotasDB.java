package com.jesus.medicaltracking.model;

import com.jesus.medicaltracking.MainActivity;

import org.w3c.dom.Text;

import java.security.PublicKey;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class NotasDB extends RealmObject {
    @PrimaryKey
    private int id;
    private String nota;


    public  NotasDB(){}

    public NotasDB(String fecha, String nota){
        id = MainActivity.NotaId.incrementAndGet();
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }


}

