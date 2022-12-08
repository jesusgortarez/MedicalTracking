package com.jesus.medicaltracking;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jesus.medicaltracking.database.BaseDatos;
import com.jesus.medicaltracking.model.AnimoBD;

import io.realm.Realm;

public class AnimoListTodosFragment extends Fragment {

    private Realm con;
    private ListView listViewAnimoListTodos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        con = BaseDatos.getInstance().conectar(getContext());
        View view =  inflater.inflate(R.layout.fragment_animo_list_todos, container, false);
        listViewAnimoListTodos = view.findViewById(R.id.listViewAnimoListTodos);
        ArrayAdapter<AnimoBD> adapter = new ArrayAdapter<AnimoBD>(getContext().getApplicationContext(),android.R.layout.simple_list_item_1,con.where(AnimoBD.class).findAll());
        listViewAnimoListTodos.setAdapter(adapter);

        // Inflate the layout for this fragment
        return view;
    }
}