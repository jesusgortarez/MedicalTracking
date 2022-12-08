package com.jesus.medicaltracking;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jesus.medicaltracking.database.BaseDatos;
import com.jesus.medicaltracking.model.MedicamentosBD;
import com.jesus.medicaltracking.model.SintomasBD;

import io.realm.Realm;

public class ConfigSintomasAgregarFragment extends Fragment {
    private Realm con;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        con = BaseDatos.getInstance().conectar(getContext());
        View view = inflater.inflate(R.layout.fragment_config_sintomas_agregar, container, false);

        Button boton = (Button) view.findViewById(R.id.agregarSintomaButton);
        TextView texto =(TextView) view.findViewById(R.id.sintomaEditText);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                con.beginTransaction();
                SintomasBD sintoma =new SintomasBD(texto.getText().toString());
                con.copyToRealmOrUpdate(sintoma);
                con.commitTransaction();


            }
        });
        return view;

    }
}