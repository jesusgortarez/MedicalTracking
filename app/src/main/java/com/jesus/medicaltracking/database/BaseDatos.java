package com.jesus.medicaltracking.database;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class BaseDatos {

    private static BaseDatos instance = new BaseDatos();
    public static BaseDatos getInstance(){
        return instance;
    }
    private Realm con;

    public Realm conectar(Context context){
         if (con==null){
             Realm.init(context);
             String nombre="PruebaBase";
             RealmConfiguration config = new RealmConfiguration.Builder().name(nombre).build();
             con = Realm.getInstance(config);
         }
         return con;
    }


}
