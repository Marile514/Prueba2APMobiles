package com.example.prueba2apmobiles;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class BaseDatos {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Equipo> teams = new ArrayList<>();

    private BaseDatos(){

    }
    //Metodo para añadir usuario.
    public static void agregarUsuario(Usuario grupoUsuario){
        usuarios.add(grupoUsuario);
    }

    //Metodo para obtener la lista de los usuario.
    public static ArrayList<Usuario> callUsuarios(){
        return usuarios;
    }
}
