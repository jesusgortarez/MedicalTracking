package com.jesus.medicaltracking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class ConfigActivity extends AppCompatActivity {

    private TabLayout configTabLayout;
    private ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        configTabLayout = findViewById(R.id.tableconfig);
        viewPager = findViewById(R.id.configviewpager);

        configTabLayout.setupWithViewPager(viewPager);

        ConfigAdapter configAdapter = new ConfigAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        configAdapter.addFragment(new ConfigMedicamentoFragment(),"Medicamentos");
        configAdapter.addFragment(new ConfigSintomasFragment(),"Sintomas");
        configAdapter.addFragment(new ConfigAnimoFragment(),"Animo");
        viewPager.setAdapter(configAdapter);


    }

}
