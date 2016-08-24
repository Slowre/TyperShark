/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import Personajes.Buceador;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 *
 * @author Flores
 */
public class HiloBuceador extends Thread {

    Buceador buceador;

    public HiloBuceador(Buceador buceador) {
        this.buceador = buceador;
    }

    @Override
    public void run() {
        while (true) {

            this.buceador.getImageView().setLayoutX(this.buceador.getPuntosRound() * 4 / 5);
            if (this.buceador.getVidas() == 0) {
                break;
            }
            
        }

    }

}
