package com.jesus.medicaltracking;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jesus.medicaltracking.database.BaseDatos;
import com.jesus.medicaltracking.model.FechasMedicamentosBD;
import com.jesus.medicaltracking.model.FechasSintomasBD;

import io.realm.Realm;

public class SintomasListDiaFragment extends Fragment {
    private Realm con;
    private ListView listViewSintoma;

    FragmentTransaction transaction;
    Fragment fragmentlista;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sintomas_list_dia, container, false);
        con = BaseDatos.getInstance().conectar(getContext());
        listViewSintoma = view.findViewById(R.id.listViewDiaListTodos);
        ArrayAdapter<FechasSintomasBD> adapter = new ArrayAdapter<FechasSintomasBD>(getContext().getApplicationContext(),android.R.layout.simple_list_item_1,con.where(FechasSintomasBD.class).equalTo("fecha",FechaGlobal.fechaGlobal).findAll());
        listViewSintoma.setAdapter(adapter);
        Log.e("Base de datos",adapter.toString());
        return view;
    }
}