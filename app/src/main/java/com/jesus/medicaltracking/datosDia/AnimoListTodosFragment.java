package com.jesus.medicaltracking.datosDia;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jesus.medicaltracking.FechaGlobal;
import com.jesus.medicaltracking.R;
import com.jesus.medicaltracking.database.BaseDatos;
import com.jesus.medicaltracking.model.FechasAnimoBD;
import com.jesus.medicaltracking.model.AnimoBD;

import io.realm.Realm;

public class AnimoListTodosFragment extends Fragment {

    private Realm con;
    private ListView listViewAnimoListTodos;

    FragmentTransaction transaction;
    Fragment fragmentlista;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        con = BaseDatos.getInstance().conectar(getContext());
        View view =  inflater.inflate(R.layout.fragment_animo_list_todos, container, false);
        listViewAnimoListTodos = view.findViewById(R.id.listViewAnimoListTodos);
        ArrayAdapter<AnimoBD> adapter = new ArrayAdapter<AnimoBD>(getContext().getApplicationContext(),android.R.layout.simple_list_item_1,con.where(AnimoBD.class).findAll());
        listViewAnimoListTodos.setAdapter(adapter);
        listViewAnimoListTodos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());
                dialogo1.setTitle("Importante");
                dialogo1.setMessage("Agregar este animo al dia con la fecha:"+ FechaGlobal.fechaGlobal);
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        String  elemento = (listViewAnimoListTodos.getItemAtPosition(i)).toString();
                        con.beginTransaction();
                        FechasAnimoBD medicamento =new FechasAnimoBD(FechaGlobal.fechaGlobal,elemento);
                        con.copyToRealmOrUpdate(medicamento);
                        con.commitTransaction();

                        fragmentlista = new AnimoListDiaFragment();
                        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.AnimoListDiaFragmentContainerView,fragmentlista).commit();
                        transaction = getActivity().getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.AnimoListDiaFragmentContainerView,fragmentlista).commit();
                    }
                });
                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                    }
                });
                dialogo1.show();

                return false;
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}