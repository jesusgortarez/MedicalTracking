package com.jesus.medicaltracking;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        con = BaseDatos.getInstance().conectar(getContext());
        View view =  inflater.inflate(R.layout.fragment_config_medicamento_list, container, false);
        listViewMedicamentos = view.findViewById(R.id.listViewMedicamentos);
        ArrayAdapter<MedicamentosBD> adapter = new ArrayAdapter<MedicamentosBD>(getContext().getApplicationContext(),android.R.layout.simple_list_item_1,con.where(MedicamentosBD.class).findAll());
        listViewMedicamentos.setAdapter(adapter);

        listViewMedicamentos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());
                dialogo1.setTitle("Importante");
                dialogo1.setMessage("¿ Elimina este medicamento?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                       String  elemento = (listViewMedicamentos.getItemAtPosition(i)).toString();
                       con.beginTransaction();
                       MedicamentosBD eliminar = con.where(MedicamentosBD.class).equalTo("nombre",elemento).findFirst();
                       eliminar.deleteFromRealm();
                       con.commitTransaction();
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

        return view;
    }

}