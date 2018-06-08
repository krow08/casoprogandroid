package com.xd.casoprog;

import java.util.ArrayList;

public class Registro {

    private static Registro regitro;

    public static Registro getInstancia() {

        if (regitro==null) {

            regitro=new Registro();
        }
        return regitro;
    }

    ArrayList<Jugador> listaScores;

    private Registro(){
        listaScores=new ArrayList<Jugador>();
    }//constructor

    public String agregarJugador(Jugador jugador){
        if(jugador!=null){
            listaScores.add(jugador);
            return  "LISTO";
        }
        return "Error al agregar";
    }//agregar

    public String getInfoJugador(int posicion){
        return listaScores.get(posicion).toString();
    }//getInfo

    public Jugador getJugador (int posicion){
        return listaScores.get(posicion);
    }

    public ArrayList<Jugador> devolverLista(){

        return listaScores;
    }//FIN MET
}