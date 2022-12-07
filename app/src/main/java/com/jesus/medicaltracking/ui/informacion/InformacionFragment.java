package com.jesus.medicaltracking.ui.informacion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.jesus.medicaltracking.R;
import com.jesus.medicaltracking.ui.informacion.InformacionViewModel;
import com.jesus.medicaltracking.databinding.FragmentInformacionBinding;
public class InformacionFragment extends Fragment {

    private FragmentInformacionBinding binding;
/*
    private TabLayout informacionTabLayout;
    private ViewPager viewPager;
    */
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