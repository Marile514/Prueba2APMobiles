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
