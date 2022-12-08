package com.jesus.medicaltracking.datosDia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.jesus.medicaltracking.NotasFragment;
import com.jesus.medicaltracking.R;

public class DatosDiaActivity extends AppCompatActivity {

    private TabLayout datosDiaTabLayout;
    private ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_dia);

        datosDiaTabLayout = findViewById(R.id.tabledia);
        viewPager = findViewById(R.id.diaviewpager);

        datosDiaTabLayout.setupWithViewPager(viewPager);

        DatosDiaAdapter datosdiaAdapter = new DatosDiaAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        datosdiaAdapter.addFragment(new NotasFragment(),"Notas");
        datosdiaAdapter.addFragment(new SintomasFragment(),"Sintomas");
        datosdiaAdapter.addFragment(new AnimoFragment(),"Animo");
        datosdiaAdapter.addFragment(new MedicamentoFragment(),"Medicamentos");
        viewPager.setAdapter(datosdiaAdapter);

    }
}

