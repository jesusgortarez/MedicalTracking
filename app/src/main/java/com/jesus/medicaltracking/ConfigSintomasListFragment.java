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
import com.jesus.medicaltracking.model.MedicamentosBD;
import com.jesus.medicaltracking.model.SintomasBD;

import io.realm.Realm;

public class ConfigSintomasListFragment extends Fragment {
    private Realm con;
    private ListView listViewSintomas;
    FragmentTransaction transaction;
    Fragment fragmentlista;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        con = BaseDatos.getInstance().conectar(getContext());
        View view = inflater.inflate(R.layout.fragment_config_sintomas_list, container, false);
        listViewSintomas = view.findViewById(R.id.listViewSintomas);
        ArrayAdapter<SintomasBD> adapter = new ArrayAdapter<SintomasBD>(getContext().getApplicationContext(),android.R.layout.simple_list_item_1,con.where(SintomasBD.class).findAll());
        listViewSintomas.setAdapter(adapter);

        listViewSintomas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());
                dialogo1.setTitle("Importante");
                dialogo1.setMessage("¿ Eliminar este Sintoma?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        String  elemento = (listViewSintomas.getItemAtPosition(i)).toString();
                        con.beginTransaction();
                        SintomasBD eliminar = con.where(SintomasBD.class).equalTo("nombre",elemento).findFirst();
                        eliminar.deleteFromRealm();
                        con.commitTransaction();

                        fragmentlista = new ConfigSintomasListFragment();
                        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.configSintomasListFragmentContainerView,fragmentlista).commit();
                        transaction = getActivity().getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.configSintomasListFragmentContainerView,fragmentlista).commit();

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