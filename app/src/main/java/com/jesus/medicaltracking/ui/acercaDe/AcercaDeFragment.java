package com.jesus.medicaltracking.ui.acercaDe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jesus.medicaltracking.ListAcercaDe;
import com.jesus.medicaltracking.ListAcercaDeAdapter;
import com.jesus.medicaltracking.R;
import com.jesus.medicaltracking.databinding.FragmentAcercaDeBinding;

import java.sql.Time;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class AcercaDeFragment extends Fragment {

    ArrayList<ListAcercaDe> listAcercaDeArrayList;
    ListView listAcercaDeListView;

    private FragmentAcercaDeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        String tag_about = getString(R.string.title_acerca_de);
        String tag_design = getString(R.string.tag_designers);
        String tag_ver = getString(R.string.tag_version);
        String tag_lver = getString(R.string.tag_last_ver);


        AcercaDeViewModel acercaDeViewModel =
                new ViewModelProvider(this).get(AcercaDeViewModel.class);

        binding = FragmentAcercaDeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        listAcercaDeListView = root.findViewById(R.id.listAcercaDeListView);
        listAcercaDeArrayList = new ArrayList<ListAcercaDe>();

        listAcercaDeArrayList.add(new ListAcercaDe(1, tag_about, "Una aplicación móvil con el propósito de llevar un seguimiento y control sobre los medicamentos que son utilizados por el usuario en su vida diaria además de poder llevar un registro sobre los efectos secundarios producidos por consumir medicamentos en específico."));
        listAcercaDeArrayList.add(new ListAcercaDe(2, tag_design, "Jesus Javier Gortarez Pelayo \nDiego Ivan Lopez Nuñes"));
        listAcercaDeArrayList.add(new ListAcercaDe(3, tag_ver, "Alpha 0.5.0"));
        listAcercaDeArrayList.add(new ListAcercaDe(4, tag_lver, "08/12/2022"));
        listAcercaDeArrayList.add(new ListAcercaDe(6,"GitHub", "https://github.com/jesusgortarez/medicaltracking"));

        ListAcercaDeAdapter listAcercaDeArrayAdapter = new ListAcercaDeAdapter(getActivity().getApplicationContext(),R.layout.item_acerca_de,listAcercaDeArrayList);

        listAcercaDeListView.setAdapter(listAcercaDeArrayAdapter);

        //detectar si es precionado algo del layout
        listAcercaDeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int id = ((ListAcercaDe)adapterView.getItemAtPosition(i)).getId();
                if (id==6){
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(((ListAcercaDe)adapterView.getItemAtPosition(i)).getData()));
                    startActivity(browserIntent);
                }

            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}