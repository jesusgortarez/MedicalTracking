package com.jesus.medicaltracking.config;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jesus.medicaltracking.R;
import com.jesus.medicaltracking.database.BaseDatos;
import com.jesus.medicaltracking.model.MedicamentosBD;

import io.realm.Realm;

public class ConfigMedicamentoAgregarFragment extends Fragment {
    private Realm con;

    FragmentTransaction transaction;
    Fragment fragmentlista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        con = BaseDatos.getInstance().conectar(getContext());
        View view = inflater.inflate(R.layout.fragment_config_medicamento_agregar, container, false);


        Button boton = (Button) view.findViewById(R.id.agregarButton);
        TextView texto =(TextView) view.findViewById(R.id.medicamentoEditText);




        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                con.beginTransaction();
                MedicamentosBD medicamento =new MedicamentosBD(texto.getText().toString());
                con.copyToRealmOrUpdate(medicamento);
                con.commitTransaction();

                fragmentlista = new ConfigMedicamentoListFragment();

                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.configMedicamentoListFragmentContainerView,fragmentlista).commit();
                transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.configMedicamentoListFragmentContainerView,fragmentlista).commit();
                /*
                ConfigMedicamentoListFragment configMedicamentoListFragment =  (ConfigMedicamentoListFragment)
                        getFragmentManager().findFragmentById(R.id.configMedicamentoListFragmentContainerView);

                Log.e("a ver que tiene", configMedicamentoListFragment.toString());



                fragmentlista = new ConfigMedicamentoListFragment();

                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.configMedicamentoListFragmentContainerView,fragmentlista).commit();
                transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.configMedicamentoListFragmentContainerView,fragmentlista).commit();
                */

                /*fragmentlista.onDestroy();
                configMedicamentoListFragment.onDestroy();
                configMedicamentoListFragment.notifyDataSetChanged();
                ((ConfigActivity) getActivity()).dataChanged();
*/

            }
        });
        return view;

    }
}