package com.jesus.medicaltracking.ui.acercaDe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jesus.medicaltracking.ListAcercaDe;
import com.jesus.medicaltracking.ListAcercaDeAdapter;
import com.jesus.medicaltracking.R;
import com.jesus.medicaltracking.databinding.FragmentAcercaDeBinding;

import java.util.ArrayList;

public class AcercaDeFragment extends Fragment {

    ArrayList<ListAcercaDe> listAcercaDeArrayList;
    ListView listAcercaDeListView;

    private FragmentAcercaDeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AcercaDeViewModel acercaDeViewModel =
                new ViewModelProvider(this).get(AcercaDeViewModel.class);

        binding = FragmentAcercaDeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        listAcercaDeListView = root.findViewById(R.id.listAcercaDeListView);
        listAcercaDeArrayList = new ArrayList<ListAcercaDe>();

        listAcercaDeArrayList.add(new ListAcercaDe(1,"Razon de la app", "bla bla"));
        listAcercaDeArrayList.add(new ListAcercaDe(2,"Diseñadores", "bla bla"));
        listAcercaDeArrayList.add(new ListAcercaDe(3,"Version", "bla bla"));
        listAcercaDeArrayList.add(new ListAcercaDe(4,"ultima fecha de vercion", "bla bla"));
        listAcercaDeArrayList.add(new ListAcercaDe(5,"no se que mas", "bla bla"));
        listAcercaDeArrayList.add(new ListAcercaDe(5,"GitHub", "bla bla"));

        ListAcercaDeAdapter listAcercaDeArrayAdapter = new ListAcercaDeAdapter(getActivity().getApplicationContext(),R.layout.item_acerca_de,listAcercaDeArrayList);

        listAcercaDeListView.setAdapter(listAcercaDeArrayAdapter);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}