package com.jesus.medicaltracking;

import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.TextView;

import com.jesus.medicaltracking.database.BaseDatos;
import com.jesus.medicaltracking.model.MedicamentosBD;
import com.jesus.medicaltracking.model.NotasDB;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

//agregue comentario

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.jesus.medicaltracking.databinding.ActivityMainBinding;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    private Realm con;
    private ActivityMainBinding binding;

    public static AtomicInteger MedicamentoId = new AtomicInteger();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        MedicamentoId = setAtomicId(con, MedicamentosBD.class);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_inicio, R.id.navigation_acerca_de, R.id.navigation_informacion)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    private <T extends RealmObject> AtomicInteger setAtomicId(Realm realm, Class<T> anyClass){
        RealmResults<T> results = realm.where(anyClass).findAll();
        return (results.size() > 0 )? new AtomicInteger(results.max("id").intValue()): new AtomicInteger();
    }


}