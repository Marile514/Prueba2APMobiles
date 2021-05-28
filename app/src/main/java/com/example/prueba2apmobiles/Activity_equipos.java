package com.example.prueba2apmobiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity_equipos extends AppCompatActivity {
    private TextView txtNombreCompl, txtDept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos);

        inits();
    }

    private void inits(){
        txtNombreCompl = findViewById(R.id.txtNombreComp);
        txtDept = findViewById(R.id.txtDepartamento);
        Bundle charge = getIntent().getExtras();
        if(charge != null){
            Usuario username = (Usuario) charge.getSerializable("Usuario");
            txtNombreCompl.setText(txtNombreCompl.getText() + " " + username.getNombre() + " " + username.getApellido());
            txtDept.setText(txtDept.getText() + " " + username.getDepartamento());
        }
    }
}