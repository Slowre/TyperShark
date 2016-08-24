/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

/**
 *
 * @author Flores
 */
public class Jugador implements Comparable<Jugador>{

    private String nombre = "";
    private String idTwitter = "";
    private int puntaje = 0;

    public Jugador(String nombre, String idTwitter, int puntaje) {
        this.nombre = nombre;
        this.idTwitter = idTwitter;
        this.puntaje = puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdTwitter() {
        return idTwitter;
    }

    public void setIdTwitter(String idTwitter) {
        this.idTwitter = idTwitter;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public int compareTo(Jugador t) {
        if (this.puntaje > t.getPuntaje()) {
            return 1;
        }
        if (this.puntaje < t.getPuntaje()) {
            return -1;
        }
        return 0;

    }
}
