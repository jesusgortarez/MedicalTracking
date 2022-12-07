package com.jesus.medicaltracking;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jesus.medicaltracking.R;
import com.jesus.medicaltracking.database.BaseDatos;
import com.jesus.medicaltracking.model.NotasDB;

import io.realm.Realm;

public class NotasFragment extends Fragment {
    private Realm con;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        con = BaseDatos.getInstance().conectar(getContext());
        View view =  inflater.inflate(R.layout.fragment_notas, container, false);

        Button boton = (Button) view.findViewById(R.id.guardarButton);
        TextView texto =(TextView) view.findViewById(R.id.editText);

        NotasDB notas = con.where(NotasDB.class).findFirst();
        //NotasDB base = con.where(NotasDB.class).equalTo("id",1).findFirst();
        texto.setText(notas.getNota());

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                con.beginTransaction();
                NotasDB base =con.where(NotasDB.class).findFirst();
                base.setNota(texto.getText().toString());
                con.copyToRealmOrUpdate(base);
                con.commitTransaction();

            }
        });

        return view;


    }



}