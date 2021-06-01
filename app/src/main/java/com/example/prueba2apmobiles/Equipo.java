package com.example.prueba2apmobiles;

import java.io.Serializable;
import java.util.ArrayList;

public class Equipo implements Serializable {
    private String serie, descripcion;
    private int valor_Equipo;

    public Equipo(String serie, String descripcion, int valor_Equipo) {
        this.serie = serie;
        this.descripcion = descripcion;
        this.valor_Equipo = valor_Equipo;
    }

    @Override
    public String toString(){
        return descripcion + ": " + valor_Equipo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getValor_Equipo() {
        return valor_Equipo;
    }

    public void setValor_Equipo(int valor_Equipo) {
        this.valor_Equipo = valor_Equipo;
    }
}
