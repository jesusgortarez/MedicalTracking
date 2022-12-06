package com.jesus.medicaltracking.ui.inf;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jesus.medicaltracking.databinding.FragmentInfBinding;

public class InfFragment extends Fragment {

    private FragmentInfBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        InfViewModel infViewModel =
                new ViewModelProvider(this).get(InfViewModel.class);

        binding = FragmentInfBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}