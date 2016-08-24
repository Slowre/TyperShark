/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Palabras;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

/**
 * Clase Letra posee un caracter y un estado
 *
 * @author Erding Israel Flores Moreno
 * @author Jefferson Alexis Del Barco Pilozo
 */
public class Letra {

    private String letra;
    Label label;
    Boolean state = false;

    /**
     * Constructor de la clase Letra
     *
     * inicializa un panel
     *
     * @param letra
     */
    public Letra(String letra) {
        this.letra = letra;
        label = new Label(letra);
        label.setFont(Font.font(null, FontWeight.BOLD, 25));
        label.setTextFill(Color.RED);
        setupTimeline();
    }

    /**
     * metodo getletra
     *
     * @return regresa el string e la primera letra
     */
    public String getletra() {
        return this.letra;
    }

    /**
     * Metodo getLabel
     *
     * @return el albel que esta la letra
     */
    public Label getLabel() {
        return this.label;
    }

    /**
     * Metodo setState
     *
     * @param state setea el estado de la letra
     */
    public void setState(Boolean state) {
        this.state = state;
    }

    /**
     * Metodo getState
     *
     * @return obtiene el estado de la letra
     */
    public Boolean getState() {
        return this.state;
    }

    /**
     * Metodo ChangeColor cambia el color de la tra a yellow
     */
    public void ChangeColor() {
        this.label.setTextFill(Color.YELLOW);
    }

    /**
     * Metodo setupTimeline pone en marcha los diferentes Keyframe que se
     * encuentran dentro
     */
    public void setupTimeline() {
        KeyFrame kf = new KeyFrame(Duration.millis(100), new CamabiarColor());
        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    /**
     * Clase interna CamabiarColor implementa la interface EventHAndler que es
     * un keyFrame de setupTimeline cuyo metodo handle cambia el color de la
     * letra segun su estado
     */
    private class CamabiarColor implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (state) {
                ChangeColor();
            }

        }

    }
}
