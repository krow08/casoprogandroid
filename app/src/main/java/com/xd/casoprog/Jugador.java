package com.xd.casoprog;

public class Jugador {

    public Jugador(String nombre, String score) {
        this.nombre = nombre;
        this.score = score;
    }

    private String nombre;
    private String score;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Nombre: "+this.getNombre()+", score: "+this.getScore();
    }
}