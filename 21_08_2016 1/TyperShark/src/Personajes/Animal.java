/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Palabras.Palabra;
import java.util.ArrayList;
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
    ArrayList<String> listaPalabras;
    Boolean murio = false;
    Boolean mato = false;

    public Animal(Image imagen, Pane layer, double x, double y, double vidas, double speed, ArrayList<String> palabras) {
        super(imagen, layer, x, y, vidas, speed);
        //pane = new Pane();
        this.imageView.relocate(x, y);
        this.addLayer();
        this.listaPalabras = palabras;
        //this.pane.getChildren().add(imageView);
        setupLabel();
        setupTimeline();
    }

    public abstract int getpuntos();

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
                mato = true;
            }

        }

    }

    public void stop() {
        this.timeline.stop();
    }

    public void play() {
        this.timeline.play();
    }

    public Boolean getMurio() {
        return murio;
    }

    public void setMurio(Boolean murio) {
        this.murio = murio;
    }

    public void setupLabel() {
        if (!this.listaPalabras.isEmpty()) {
            palabra = new Palabra(this.listaPalabras.get(0));
            this.layer.getChildren().add(palabra.getPane());
        }
    }

    public Boolean getMato() {
        return mato;
    }

    public void setMato(Boolean mato) {
        this.mato = mato;
    }

    public void aumentarVelocidad() {
        this.speed = this.speed + 2;
    }

    public void removePalabra() {
        this.layer.getChildren().remove(this.palabra.getPane());
        if (this.vidas == 0) {

            this.timeline.stop();
        }
    }

    public void matarAnimal() {
        //this.listaPalabras.clear();
        removeBicho();
        removePalabra();
        this.murio = true;

    }

    public void inputLetras(String code) {
        palabra.input(code);
        if (!palabra.isCheckinput()) {
            aumentarVelocidad();
            palabra.setCheckinput(true);
        }
        if (palabra.checkPalabra()) {
            this.setVidas(this.getVidas() - 1);
            if (this.getVidas() == 0) {
                System.out.println("ganaste");
                //murio();
                matarAnimal();
//                this.murio = true;
                this.listaPalabras.remove(0);
            } else {
                this.murio = true;
                removePalabra();
                this.listaPalabras.remove(0);
                setupLabel();
            }

        }
    }

    public void setup() {
        this.palabra.getPane().relocate(imageView.getLayoutX() + imageView.getFitWidth() / 2, y + 50);
    }

}
