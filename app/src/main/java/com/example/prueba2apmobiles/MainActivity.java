package com.example.prueba2apmobiles;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
    private String idUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Inits();
        listSistem();
    }

    private void Inits(){
        listaUsuarios = findViewById(R.id.lstUsuarios);

        datosCargados();

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
        //Metodo para hacer long click para preguntar si desea eliminar un usuario.
        listaUsuarios.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Usuario b = (Usuario) parent.getItemAtPosition(position);
                idUser = b.getUsuario();
                alertDialogoUser();
                return true;
            }
        });
    }

    private void alertDialogoUser(){
        AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
        dialogo.setTitle("Título");
        dialogo.setMessage("¿Deseas eliminar un usuario?");
        dialogo.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //El setButton para borrar un usuario.
                //Logica para borrar usuario.
                BaseDatos.eliminarUsuario(idUser);
                //Recargar el adapter de la lista de usuarios.
                users = new ArrayAdapter<Usuario>(MainActivity.this, android.R.layout.simple_list_item_1, BaseDatos.callUsuarios());
                listaUsuarios.setAdapter(users);
            }
        });
        dialogo.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog d = dialogo.create();
        d.show();
    }

    private void datosCargados(){
        //Crear y agregar Agregar usuarios.
        BaseDatos.agregarUsuario(new Usuario("Ricochet","Ronald","Castro","Las estrellas"));
        BaseDatos.agregarUsuario(new Usuario("LuchitoBladeEX","Luis","Marileo","Trivago"));
        BaseDatos.agregarUsuario(new Usuario("RedEyes","Wladimir","Mejías","Las Vegas"));

        //Asignar equipos a cada usuario.
        BaseDatos.agregarEquipoAUsuario("Ricochet", new Equipo("111","hsadhgfs",4000));
        BaseDatos.agregarEquipoAUsuario("Ricochet", new Equipo("222","Juego de pelea",24000));
        BaseDatos.agregarEquipoAUsuario("Ricochet", new Equipo("333","Deporte",10000));

        BaseDatos.agregarEquipoAUsuario("LuchitoBladeEX", new Equipo("444","hasjhgdfsv",9000));
        BaseDatos.agregarEquipoAUsuario("LuchitoBladeEX", new Equipo("555","ahshghgf",25000));
        BaseDatos.agregarEquipoAUsuario("LuchitoBladeEX", new Equipo("666","ahgsgsahg",11000));

        BaseDatos.agregarEquipoAUsuario("RedEyes", new Equipo("777","sdsdagfkjsdhf",7000));
        BaseDatos.agregarEquipoAUsuario("RedEyes", new Equipo("888","dsasdfjhds",35000));
        BaseDatos.agregarEquipoAUsuario("RedEyes", new Equipo("999","jhadsjhdsfjhsd",19000));
    }
}