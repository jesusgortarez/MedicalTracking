package com.jesus.medicaltracking.ui.acercaDe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jesus.medicaltracking.databinding.FragmentAcercaDeBinding;

public class AcercaDeFragment extends Fragment {

    private FragmentAcercaDeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AcercaDeViewModel acercaDeViewModel =
                new ViewModelProvider(this).get(AcercaDeViewModel.class);

        binding = FragmentAcercaDeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}