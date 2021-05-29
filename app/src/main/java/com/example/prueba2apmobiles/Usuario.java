package com.example.prueba2apmobiles;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {
    private String usuario, nombre, apellido, departamento;
    private ArrayList<Equipo> equipos = new ArrayList<>();

    public Usuario(String usuario, String nombre, String apellido, String departamento) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.departamento = departamento;

        equipos.add(new Equipo("AAA","Desc1",2000));
        equipos.add(new Equipo("BBB","Desc2",4000));
        equipos.add(new Equipo("CCC","Desc3",6000));
        equipos.add(new Equipo("DDD","Desc4", 42000));
        equipos.add(new Equipo("EEE","Desc5", 35000));
        equipos.add(new Equipo("FFF","Desc6", 28000));
        equipos.add(new Equipo("GGG","Desc7",51000));
        equipos.add(new Equipo("HHH","Desc8",44000));
        equipos.add(new Equipo("III","Desc9",11000));
    }

    public ArrayList<Equipo> getEquipos(){
        return equipos;
    }

    @Override
    public String toString() {
        return nombre +" " + apellido + "     " + departamento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
