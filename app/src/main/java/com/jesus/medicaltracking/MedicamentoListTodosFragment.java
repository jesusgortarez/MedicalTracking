package com.jesus.medicaltracking;

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

import com.jesus.medicaltracking.database.BaseDatos;
import com.jesus.medicaltracking.model.FechasMedicamentosBD;
import com.jesus.medicaltracking.model.MedicamentosBD;

import io.realm.Realm;

public class MedicamentoListTodosFragment extends Fragment {
    private Realm con;
    private ListView listViewMedicamentoListTodos;

    FragmentTransaction transaction;
    Fragment fragmentlista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        con = BaseDatos.getInstance().conectar(getContext());
        View view =  inflater.inflate(R.layout.fragment_medicamento_list_todos, container, false);
        listViewMedicamentoListTodos = view.findViewById(R.id.listViewMedicamentoListTodos);
        ArrayAdapter<MedicamentosBD> adapter = new ArrayAdapter<MedicamentosBD>(getContext().getApplicationContext(),android.R.layout.simple_list_item_1,con.where(MedicamentosBD.class).findAll());
        listViewMedicamentoListTodos.setAdapter(adapter);
        listViewMedicamentoListTodos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());
                dialogo1.setTitle("Importante");
                dialogo1.setMessage("Agregar este medicamento al dia con la fecha:"+ FechaGlobal.fechaGlobal);
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        String  elemento = (listViewMedicamentoListTodos.getItemAtPosition(i)).toString();
                        con.beginTransaction();
                        FechasMedicamentosBD medicamento =new FechasMedicamentosBD(FechaGlobal.fechaGlobal,elemento);
                        con.copyToRealmOrUpdate(medicamento);
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
        // Inflate the layout for this fragment
        return view;
    }
}