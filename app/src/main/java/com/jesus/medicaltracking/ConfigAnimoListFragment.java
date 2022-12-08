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
import com.jesus.medicaltracking.model.AnimoBD;
import com.jesus.medicaltracking.model.MedicamentosBD;

import io.realm.Realm;

public class ConfigAnimoListFragment extends Fragment {
    private Realm con;
    private ListView listViewAnimos;
    FragmentTransaction transaction;
    Fragment fragmentlista;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        con = BaseDatos.getInstance().conectar(getContext());
        View view =  inflater.inflate(R.layout.fragment_config_animo_list, container, false);
        listViewAnimos = view.findViewById(R.id.listViewAnimos);
        ArrayAdapter<AnimoBD> adapter = new ArrayAdapter<AnimoBD>(getContext().getApplicationContext(),android.R.layout.simple_list_item_1,con.where(AnimoBD.class).findAll());
        listViewAnimos.setAdapter(adapter);

        listViewAnimos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());
                dialogo1.setTitle("Importante");
                dialogo1.setMessage("¿ Eliminar este estado de animo?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        String  elemento = (listViewAnimos.getItemAtPosition(i)).toString();
                        con.beginTransaction();
                        AnimoBD eliminar = con.where(AnimoBD.class).equalTo("nombre",elemento).findFirst();
                        eliminar.deleteFromRealm();
                        con.commitTransaction();
                        fragmentlista = new ConfigAnimoListFragment();
                        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.configAnimoListFragmentContainerView,fragmentlista).commit();
                        transaction = getActivity().getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.configAnimoListFragmentContainerView,fragmentlista).commit();

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