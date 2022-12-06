package com.jesus.medicaltracking.ui.informacion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jesus.medicaltracking.databinding.FragmentInformacionBinding;

public class InformacionFragment extends Fragment {

    private FragmentInformacionBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        InformacionViewModel informacionViewModel =
                new ViewModelProvider(this).get(InformacionViewModel.class);

        binding = FragmentInformacionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}