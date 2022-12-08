package com.jesus.medicaltracking;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jesus.medicaltracking.database.BaseDatos;
import com.jesus.medicaltracking.model.MedicamentosBD;

import io.realm.Realm;

public class MedicamentoListTodosFragment extends Fragment {
    private Realm con;
    private ListView listViewMedicamentoListTodos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        con = BaseDatos.getInstance().conectar(getContext());
        View view =  inflater.inflate(R.layout.fragment_medicamento_list_todos, container, false);
        listViewMedicamentoListTodos = view.findViewById(R.id.listViewMedicamentoListTodos);
        ArrayAdapter<MedicamentosBD> adapter = new ArrayAdapter<MedicamentosBD>(getContext().getApplicationContext(),android.R.layout.simple_list_item_1,con.where(MedicamentosBD.class).findAll());
        listViewMedicamentoListTodos.setAdapter(adapter);

        // Inflate the layout for this fragment
        return view;
    }
}