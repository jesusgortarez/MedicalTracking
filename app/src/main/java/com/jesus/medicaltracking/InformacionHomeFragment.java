package com.jesus.medicaltracking;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.jesus.medicaltracking.database.BaseDatos;
import com.jesus.medicaltracking.datosDia.DatosDiaActivity;
import com.jesus.medicaltracking.model.FechasAnimoBD;
import com.jesus.medicaltracking.model.FechasMedicamentosBD;
import com.jesus.medicaltracking.model.FechasSintomasBD;
//import com.jesus.medicaltracking.model.NotasBD;
import java.util.ArrayList;

import io.realm.Realm;


public class InformacionHomeFragment extends Fragment {

    ArrayList<ListAcercaDe> listAcercaDeArrayList;
    ListView listAcercaDeListView;

    Button diaButton;
    private Realm con;
    private ListView listViewMedicamentos;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_informacion_home, container, false);

        diaButton = (Button) v.findViewById(R.id.diaButton);
        listAcercaDeListView = v.findViewById(R.id.informacionHomeListView);
        listAcercaDeArrayList = new ArrayList<ListAcercaDe>();

        con = BaseDatos.getInstance().conectar(getContext());
        //ArrayAdapter<FechasMedicamentosBD> adapter = new ArrayAdapter<FechasMedicamentosBD>(getContext().getApplicationContext(),android.R.layout.simple_list_item_1,con.where(FechasMedicamentosBD.class).equalTo("fecha",FechaGlobal.fechaGlobal).findAll());

        FechasMedicamentosBD fechasMedicamentosBD;
        fechasMedicamentosBD = con.where(FechasMedicamentosBD.class).equalTo("fecha",FechaGlobal.fechaGlobal).findFirst();

        FechasAnimoBD fechasAnimoBD;
        fechasAnimoBD = con.where(FechasAnimoBD.class).equalTo("fecha",FechaGlobal.fechaGlobal).findFirst();
        /*
        NotasBD fechasnotasBD;
        fechasnotasBD = con.where(NotasBD.class).equalTo("fecha",FechaGlobal.fechaGlobal).findFirst();
        */
        FechasSintomasBD fechasSintomasBD;
        fechasSintomasBD = con.where(FechasSintomasBD.class).equalTo("fecha",FechaGlobal.fechaGlobal).findFirst();

        //Log.e("base de datos 123", con.where(FechasMedicamentosBD.class).equalTo("fecha",FechaGlobal.fechaGlobal).toString());
        //Log.e("base de datos 123", fechasMedicamentosBD.getMedicamento());
        //Log.e("base de datos 123", con.where(FechasMedicamentosBD.class).findFirst().toString());
        listAcercaDeArrayList.add(new ListAcercaDe(1, "Notas", "Sin notas"));

        if (fechasSintomasBD==null){
            listAcercaDeArrayList.add(new ListAcercaDe(2, "Sintomas", "Sin sintomas"));
        }
        else{
            listAcercaDeArrayList.add(new ListAcercaDe(2, "Sintomas", fechasSintomasBD.getSintoma()));
        }

        if (fechasAnimoBD==null){
            listAcercaDeArrayList.add(new ListAcercaDe(3, "Animo anormal", "Sin animo anormal"));
        }
        else{
            listAcercaDeArrayList.add(new ListAcercaDe(3, "Animo anormal", fechasAnimoBD.getAnimo()));
        }

        if (fechasMedicamentosBD==null){
            listAcercaDeArrayList.add(new ListAcercaDe(4, "Medicamentos", "Sin medicamentos"));
        }
        else{
            listAcercaDeArrayList.add(new ListAcercaDe(4, "Notas", fechasMedicamentosBD.getMedicamento()));
        }
        ListAcercaDeAdapter listAcercaDeArrayAdapter = new ListAcercaDeAdapter(getActivity().getApplicationContext(),R.layout.item_acerca_de,listAcercaDeArrayList);
        listAcercaDeListView.setAdapter(listAcercaDeArrayAdapter);

        diaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Abre un activity desde un fragment
                Intent intent = new Intent(getActivity(), DatosDiaActivity.class);
                ((MainActivity) getActivity()).startActivity(intent);

            }
        });
        return v;
    }

}
