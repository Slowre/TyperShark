/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

/**
 * Clase Jugador hereda del a clase Comparable para poder ordenar los jugadores
 * en una lista
 *
 * @author Erding Israel Flores Moreno
 * @author Jefferson Alexis Del Barco Pilozo
 */
public class Jugador implements Comparable<Jugador> {

    private String nombre = "";
    private String idTwitter = "";
    private int puntaje = 0;

    /**
     * Constructor de la clase Jugador
     *
     *
     * @param nombre
     * @param idTwitter
     * @param puntaje
     */
    public Jugador(String nombre, String idTwitter, int puntaje) {
        this.nombre = nombre;
        this.idTwitter = idTwitter;
        this.puntaje = puntaje;
    }

    /**
     * metodo getNombre
     *
     *
     * @return obtiene el nombre del jugador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * metodo setNombre
     *
     * @param nombre setea el nombre del juhgador
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * metodo getIdTwitter
     *
     *
     * @return obtiene el id twittet del jugador
     */
    public String getIdTwitter() {
        return idTwitter;
    }

    /**
     * metodo setIdTwitter
     *
     * @param idTwitter setea el id twitter del jugador
     */
    public void setIdTwitter(String idTwitter) {
        this.idTwitter = idTwitter;
    }

    /**
     * metodo getPuntaje
     *
     *
     * @return obtiene el puntaje del jugador
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * metodo setPuntaje
     *
     * @param puntaje setea el puntaje ddel jugador
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * metodo compareTo sobreescrito
     *
     * metodo par poder ordenar una lista de jugadores de manera ascendente
     *
     * @param t
     * @return
     */
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
