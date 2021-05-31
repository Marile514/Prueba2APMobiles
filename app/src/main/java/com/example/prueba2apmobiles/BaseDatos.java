package com.example.prueba2apmobiles;

import android.util.Log;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class BaseDatos {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Equipo> teams = new ArrayList<>();

    private BaseDatos(){

    }

    public static void eliminarUsuario(String user){
        ArrayList<Usuario> lista = usuarios;
        Usuario u = null;
        for (Usuario us:lista) {
            if(us.getUsuario().equals(user)){//Encuentra el usuario
                u = us;
            }
        }
        if(u != null){
            usuarios.remove(u);
        }else{
            Log.d("ERR_", "borrarUsuario: falla borrar usuario");
        }
    }
    //Metodo para añadir usuario.
    public static void agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    //Metodo para obtener la lista de los usuario.
    public static ArrayList<Usuario> callUsuarios(){
        return usuarios;
    }

    //Metodo para agregar equipos.
    public static void agregarEquipos(Equipo equipo){
        teams.add(equipo);
    }

    //Metodo para añadir equipos a un usuario.
    public static void agregarEquipoAUsuario(String us, Equipo c){
        for (Usuario user:usuarios){
            if(user.getUsuario().equals(us)){
                teams.add(c);
            }
        }
    }
    
    //Metodo para eliminar un equipo a un usuario
    public static void eliminarEquipoDeUsuario(String us, String serie){
        ArrayList<Equipo> cloneList = teams;
        for (Usuario user:usuarios) {
            if(user.getUsuario().equals(us)){
                for (Equipo c:cloneList) {
                    if(c.getSerie().equals(serie)){
                        teams.remove(c);
                    }
                }
            }
        }
    }

    public static void cambiarUsuario(String usuario, String p){
        for (Usuario user:usuarios) {
            if(user.getUsuario().equals(usuario)){

            }
        }
    }
}
