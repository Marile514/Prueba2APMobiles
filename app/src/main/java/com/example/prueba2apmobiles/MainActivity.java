package com.example.prueba2apmobiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

        setearLista();
    }

    private void setearLista(){
        listaUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Usuario user = (Usuario) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Usuario: " + user.getUsuario(), Toast.LENGTH_LONG).show();
            }
        });
    }

    //Método para transferir datos con click y longClick para alertDialog
    private void listSistem(){
        //click para transferir los datos a la activity_equipos.
        listaUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Usuario b = (Usuario) parent.getItemAtPosition(position);
                Intent c = new Intent(MainActivity.this, Activity_equipos.class);
                c.putExtra("Usuario", b);
                startActivity(c);
            }
        });
    }
}