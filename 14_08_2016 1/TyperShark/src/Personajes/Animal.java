/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Constantes.Settings;
import Palabras.Palabra;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author Flores
 */
public abstract class Animal extends SpriteBase {

    Palabra palabra;
    Pane pane;
    Timeline timeline;

    public Animal(Image imagen, Pane layer, double x, double y, double vidas, double speed, String palabra) {
        super(imagen, layer, x, y, vidas, speed);
        //pane = new Pane();
        this.imageView.relocate(x, y);
        this.addLayer();
        //this.pane.getChildren().add(imageView);
        setupLabel(palabra);
        setupTimeline();
    }

    public void murio() {
        this.setVidas(0);

    }

    public Pane getPane() {
        return pane;
    }

    public void setupTimeline() {
        KeyFrame kf = new KeyFrame(Duration.millis(100), new TimeHandler());
        timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private class TimeHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            imageView.setLayoutX(imageView.getLayoutX() - speed);
            palabra.getPane().setLayoutX(palabra.getPane().getLayoutX() - speed);
            if (imageView.getLayoutX() < (0 - imageView.getFitWidth())) {
                murio();
            }

        }

    }

    public void setupLabel(String cadena) {
        palabra = new Palabra(cadena);
        this.layer.getChildren().add(palabra.getPane());
    }

    public void aumentarVelocidad() {
        this.speed = this.speed * 2;
    }

    public void removePalabra() {
        if (this.vidas == 0) {
            this.layer.getChildren().remove(this.palabra.getPane());
            this.timeline.stop();
        }
    }

    public void inputLetras(String code) {
        palabra.input(code);
        if (!palabra.isCheckinput()) {
            aumentarVelocidad();
            palabra.setCheckinput(true);
        }
        if (palabra.checkPalabra()) {
            System.out.println("ganaste");
            murio();
            removeBicho();
            removePalabra();
        }
    }

}
