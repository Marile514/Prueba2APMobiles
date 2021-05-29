package com.example.prueba2apmobiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_equipos extends AppCompatActivity {
    private TextView txtNombreCompl, txtDept;
    private EditText descrTeam, valorTeam;
    private AutoCompleteTextView serieTeam;

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
        descrTeam = findViewById(R.id.etTipoEquipo);
        valorTeam = findViewById(R.id.etValorEquipo);
        serieTeam = findViewById(R.id.acSerie);

        Bundle charge = getIntent().getExtras();
        if(charge != null){
            Usuario username = (Usuario) charge.getSerializable("Usuario");
            txtNombreCompl.setText(txtNombreCompl.getText() + " " + username.getNombre() + " " + username.getApellido());
            txtDept.setText(txtDept.getText() + " " + username.getDepartamento());
        }
    }
}