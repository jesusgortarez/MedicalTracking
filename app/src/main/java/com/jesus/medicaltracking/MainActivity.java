package com.jesus.medicaltracking;

import android.os.Bundle;

import com.jesus.medicaltracking.database.BaseDatos;
import com.jesus.medicaltracking.model.NotasDB;

import io.realm.Realm;

//agregue comentario

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.jesus.medicaltracking.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Realm con;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        con = BaseDatos.getInstance().conectar(getBaseContext());
        long cantidad = con.where(NotasDB.class).count();
        if (cantidad ==0){
            NotasDB notas = new NotasDB();
            notas.setId(1);
            notas.setNota("Escribir observaciones");

            con.beginTransaction();
            con.copyToRealmOrUpdate(notas);
            con.commitTransaction();
        }


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_informacion)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}