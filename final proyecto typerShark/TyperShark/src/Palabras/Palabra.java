/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Palabras;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.HBox;

/**
 * Clase Palabra posee la las letras que contiene la palabra que tendra el
 * animal
 *
 * @author Erding Israel Flores Moreno
 * @author Jefferson Alexis Del Barco Pilozo
 */
public class Palabra {

    HBox hBoxPalabra;
    List<Letra> letras;
    String palabra;
    boolean checkinput = true;

    /**
     * Constructor de la clase Letra
     *
     * inicializa un panel
     *
     * @param palabra
     */
    public Palabra(String palabra) {
        this.palabra = palabra;
        letras = new ArrayList<>();
        this.llenarLetras();
        hBoxPalabra = new HBox();
        llenarHbox();
    }

    /**
     * Metodo getletra llena de letra la lista segun la palabra
     */
    public void llenarLetras() {
        String[] letrasCargadas = this.palabra.split("");
        for (String letra : letrasCargadas) {
            Letra letraTemp = new Letra(letra);
            letras.add(letraTemp);
        }
    }

    /**
     * Metodo llenarHbox llenara un vbox con lños panes de cada letra de la
     * palabra
     */
    public void llenarHbox() {

        for (Letra letra : this.letras) {
            this.hBoxPalabra.getChildren().add(letra.getLabel());
        }
    }

    /**
     * Metodo getPane
     *
     * @return regresara el hbox que tiene la palabra
     */
    public HBox getPane() {
        return this.hBoxPalabra;
    }

    /**
     * Metodo checkPalabra
     *
     * @return true si la palabra fue completada
     */
    public Boolean checkPalabra() {
        int cont = 0;
        for (Letra letras : this.letras) {
            if (letras.getState()) {
                cont++;
            }
        }
        if (cont == this.letras.size()) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Metodo isCheckinput
     *
     * @return true si el ingreso fue correcto
     */
    public boolean isCheckinput() {
        return checkinput;
    }

    /**
     * Metodo setCheckinput
     *
     * @param checkinput setea si el ingeso fue correcto
     */
    public void setCheckinput(boolean checkinput) {
        this.checkinput = checkinput;
    }

    /**
     * Metodo input
     *
     * @param letra ingresa uan letra y mira si la primera letra de la palabra
     * coincide
     */
    public void input(String letra) {

        for (Letra letras : this.letras) {
            if (!letras.getState()) {
                if (letras.getletra().equalsIgnoreCase(letra)) {
                    letras.setState(true);
                    break;
                } else {
                    System.out.println("mal ingreso");
                    this.setCheckinput(false);
                    break;
                }
            }
        }
    }

}
