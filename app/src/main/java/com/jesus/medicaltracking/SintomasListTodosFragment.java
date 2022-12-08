package com.jesus.medicaltracking;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jesus.medicaltracking.database.BaseDatos;
import com.jesus.medicaltracking.model.SintomasBD;

import io.realm.Realm;

public class SintomasListTodosFragment extends Fragment {

    private Realm con;
    private ListView listViewSintomasListTodos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        con = BaseDatos.getInstance().conectar(getContext());
        View view =  inflater.inflate(R.layout.fragment_sintomas_list_todos, container, false);
        listViewSintomasListTodos = view.findViewById(R.id.listViewSintomasListTodos);
        ArrayAdapter<SintomasBD> adapter = new ArrayAdapter<SintomasBD>(getContext().getApplicationContext(),android.R.layout.simple_list_item_1,con.where(SintomasBD.class).findAll());
        listViewSintomasListTodos.setAdapter(adapter);

        // Inflate the layout for this fragment
        return view;
    }
}