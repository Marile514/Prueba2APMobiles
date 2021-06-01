package com.example.prueba2apmobiles;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity_equipos extends AppCompatActivity {
    private TextView txtNombreCompl, txtDept, txtPrecioTotal;
    private EditText descrTeam, valorTeam;
    private AutoCompleteTextView serieTeam;
    private Button agregar, volver;
    private ListView datos;
    private ArrayAdapter teamers;
    private String equipo, us, equip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos);

        inits();
        events();
    }

    private void inits(){
        //Referenciar variables de los componentes.
        txtNombreCompl = findViewById(R.id.txtNombreComp);
        txtDept = findViewById(R.id.txtDepartamento);
        txtPrecioTotal = findViewById(R.id.txtPrecioTotal);
        datos = findViewById(R.id.lstPrecios);
        descrTeam = findViewById(R.id.etTipoEquipo);
        valorTeam = findViewById(R.id.etValorEquipo);
        serieTeam = findViewById(R.id.acSerie);
        agregar = findViewById(R.id.btnAdd);
        volver = findViewById(R.id.btnVolver);

        teamers = new ArrayAdapter<Equipo>(Activity_equipos.this, android.R.layout.simple_list_item_1, BaseDatos.llamarEquipo());
        datos.setAdapter(teamers);

        transferenciaUsuario();
        setearListaEquipo();
    }

    private void transferenciaUsuario(){
        Bundle charge = getIntent().getExtras();
        if(charge != null){
            Usuario username = (Usuario) charge.getSerializable("Usuario");
            txtNombreCompl.setText(txtNombreCompl.getText() + " " + username.getNombre() + " " + username.getApellido());
            txtDept.setText(txtDept.getText() + " " + username.getDepartamento());
        }
    }

    private void setearListaEquipo(){
        datos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Equipo team = (Equipo) parent.getItemAtPosition(position);
                Toast.makeText(Activity_equipos.this, "Serie: " + team.getSerie(), Toast.LENGTH_LONG).show();
            }
        });
    }

    //Método para los botones agregar, eliminar y volver.
    private void events(){
        //Realizar la funcion de boton eliminar en la listview de datos.
        datos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Equipo c = (Equipo) parent.getItemAtPosition(position);
                equipo = c.getSerie();
                alertDialogoEquipo();
                return true;
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void alertDialogoEquipo(){
        AlertDialog.Builder dialogo2 = new AlertDialog.Builder(Activity_equipos.this);
        dialogo2.setTitle("Equipos del usuario");
        dialogo2.setMessage("¿Desea borrar un equipo del usuario?");
        //Implementar setButton para borrar un equipo del usuario.
        dialogo2.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Lógica para borrar un equipo del usuario.
                BaseDatos.eliminarEquipoDeUsuario(us, equip);
                //Recargar el adapter de los equipos.
                teamers = new ArrayAdapter<Equipo>(Activity_equipos.this, android.R.layout.simple_list_item_1, BaseDatos.llamarEquipo());
                datos.setAdapter(teamers);
            }
        });
        dialogo2.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog accion = dialogo2.create();
        accion.show();
    }

}