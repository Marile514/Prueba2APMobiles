package com.example.prueba2apmobiles;

import androidx.appcompat.app.AppCompatActivity;

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
    private Button agregar, eliminar, volver;
    private ListView datos;
    private ArrayAdapter teamers;
    private String equipo, teamUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos);

        inits();
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
        eliminar = findViewById(R.id.btnDelete);
        volver = findViewById(R.id.btnVolver);

        teamers = new ArrayAdapter<Equipo>(Activity_equipos.this, android.R.layout.simple_list_item_1, BaseDatos.agregarEquipos(););
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
        eliminar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //Lógica para eliminar un equipo.
                BaseDatos.eliminarEquipoDeUsuario(teamUser, equipo);
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

}