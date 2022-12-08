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
import com.jesus.medicaltracking.model.FechasSintomasBD;
import com.jesus.medicaltracking.model.SintomasBD;

import io.realm.Realm;

public class SintomasListTodosFragment extends Fragment {

    private Realm con;
    private ListView listViewSintomasListTodos;

    FragmentTransaction transaction;
    Fragment fragmentlista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        con = BaseDatos.getInstance().conectar(getContext());
        View view =  inflater.inflate(R.layout.fragment_sintomas_list_todos, container, false);
        listViewSintomasListTodos = view.findViewById(R.id.listViewSintomasListTodos);
        ArrayAdapter<SintomasBD> adapter = new ArrayAdapter<SintomasBD>(getContext().getApplicationContext(),android.R.layout.simple_list_item_1,con.where(SintomasBD.class).findAll());
        listViewSintomasListTodos.setAdapter(adapter);

        listViewSintomasListTodos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());
                dialogo1.setTitle("Importante");
                dialogo1.setMessage("Agregar este sintoma al dia con la fecha:"+ FechaGlobal.fechaGlobal);
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        String  elemento = (listViewSintomasListTodos.getItemAtPosition(i)).toString();
                        con.beginTransaction();
                        FechasSintomasBD sintoma =new FechasSintomasBD(FechaGlobal.fechaGlobal,elemento);
                        con.copyToRealmOrUpdate(sintoma);
                        con.commitTransaction();

                        fragmentlista = new SintomasListDiaFragment();
                        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.SintomasListDiaFragmentContainerView,fragmentlista).commit();
                        transaction = getActivity().getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.SintomasListDiaFragmentContainerView,fragmentlista).commit();
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