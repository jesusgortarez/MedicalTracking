package com.jesus.medicaltracking;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jesus.medicaltracking.database.BaseDatos;
import com.jesus.medicaltracking.model.AnimoBD;
import com.jesus.medicaltracking.model.MedicamentosBD;

import io.realm.Realm;

public class ConfigAnimoAgregarFragment extends Fragment {
    private Realm con;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        con = BaseDatos.getInstance().conectar(getContext());
        View view = inflater.inflate(R.layout.fragment_config_animo_agregar, container, false);

        Button boton = (Button) view.findViewById(R.id.agregarAnimoButton);
        TextView texto =(TextView) view.findViewById(R.id.animoEditText);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                con.beginTransaction();
                AnimoBD animo =new AnimoBD(texto.getText().toString());
                con.copyToRealmOrUpdate(animo);
                con.commitTransaction();


            }
        });

        return view;
    }
}