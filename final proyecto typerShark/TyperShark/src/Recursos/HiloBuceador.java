/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import Personajes.Buceador;
import javafx.application.Platform;

/**
 * Clase HiloBuceador una clase hecha para mover al buceador segun su puntaje en
 * un round
 *
 * @author Erding Israel Flores Moreno
 * @author Jefferson Alexis Del Barco Pilozo
 */
public class HiloBuceador extends Thread {

    Buceador buceador;

    /**
     * Constructor de la clase HiloBuceador setea al buceador de esta clase
     *
     *
     * @param buceador
     */
    public HiloBuceador(Buceador buceador) {
        this.buceador = buceador;
    }

    /**
     * metodo run de la clase Thread
     *
     * mueve al imageview del buceador segun su puntaje del round en el que este
     * y el metodo termina si el buceador muere
     */
    @Override
    public void run() {

        try {
            while (true) {
                this.buceador.getImageView().setLayoutX(this.buceador.getPuntosRound() * 4 / 5);
                if (this.buceador.getVidas() == 0) {
                    break;
                }

                Thread.sleep(10);
            }
        } catch (InterruptedException ex) {

        }

    }

}
