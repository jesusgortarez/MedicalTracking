package com.jesus.medicaltracking;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jesus.medicaltracking.database.BaseDatos;
import com.jesus.medicaltracking.model.MedicamentosBD;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class ConfigMedicamentoListFragment extends Fragment {
    private Realm con;
    private ListView listViewMedicamentos;
;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        con = BaseDatos.getInstance().conectar(getContext());
        View view =  inflater.inflate(R.layout.fragment_config_medicamento_list, container, false);

        listViewMedicamentos = view.findViewById(R.id.listViewMedicamentos);

        ArrayAdapter<MedicamentosBD> adapter = new ArrayAdapter<MedicamentosBD>(getContext(),android.R.layout.simple_list_item_1,con.where(MedicamentosBD.class).findAll());

        listViewMedicamentos.setAdapter(adapter);



        return view;
    }
}