package com.example.prueba2apmobiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listaUsuarios;
    private ArrayAdapter users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Inits();
    }

    private void Inits(){
        listaUsuarios = findViewById(R.id.lstUsuarios);

        //Crear y agregar Agregar usuarios.
        BaseDatos.agregarUsuario(new Usuario("Ricochet","Ronald","Castro","Las estrellas"));
        BaseDatos.agregarUsuario(new Usuario("LuchitoBladeEX","Luis","Marileo","Trivago"));
        BaseDatos.agregarUsuario(new Usuario("RedEyes","Wladimir","Mejías","Las Vegas"));

        users = new ArrayAdapter<Usuario>(MainActivity.this, android.R.layout.simple_list_item_1, BaseDatos.callUsuarios());
        listaUsuarios.setAdapter(users);
    }


}