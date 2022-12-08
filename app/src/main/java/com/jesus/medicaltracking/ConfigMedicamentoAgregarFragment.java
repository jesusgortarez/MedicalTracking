package com.jesus.medicaltracking;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jesus.medicaltracking.database.BaseDatos;
import com.jesus.medicaltracking.model.MedicamentosBD;
import com.jesus.medicaltracking.model.NotasDB;

import io.realm.Realm;

public class ConfigMedicamentoAgregarFragment extends Fragment {
    private Realm con;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        con = BaseDatos.getInstance().conectar(getContext());
        View view = inflater.inflate(R.layout.fragment_config_medicamento_agregar, container, false);


        Button boton = (Button) view.findViewById(R.id.agregarButton);
        TextView texto =(TextView) view.findViewById(R.id.medicamentoEditText);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                con.beginTransaction();
                MedicamentosBD medicamento =new MedicamentosBD(texto.getText().toString());
                con.copyToRealmOrUpdate(medicamento);
                con.commitTransaction();

            }
        });
        return view;

    }
}