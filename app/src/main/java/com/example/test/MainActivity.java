package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AdapterView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView barra;
    //Primero debemos crear un archivo XML del tipo menu y otro del tipo Navigation
    //En el de tipo menu diremos los items que tendrá nuestro menu y en el de tipo navigation diremos los fragmentos que tendrá nuestra app
    //Un fragmento es una especie de componente que se embebe en una actividad, con el menu cambiaremos entre ellos sin cambiar de actividad y será como
    // cambiar entre actividades.
    Principal fragmentoPrincipal = new Principal();
    Segundo fragmentoSecundario = new Segundo();
    Tercero fragmentoTercero = new Tercero();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barra = findViewById(R.id.barraNav);

        //El fragmento se cambiará mediante una especie de transacción
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentoPrincipal).commit();

        //Para cambiar entre fragmentos basicamente añadiremos un evento a la barra de navegación
        barra.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.primerItem:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentoPrincipal).commit();
                        return true;}
                    case R.id.segundoItem:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentoSecundario).commit();
                        return true;
                    }
                    case R.id.tercerItem:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentoTercero).commit();
                        return true;
                    }

                }


                return false;
            }
        });
    }
}