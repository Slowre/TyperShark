/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Palabras.Palabra;
import java.io.File;
import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 * Clase Animal es una clase abstracta que es hija de unn ser vivo
 *
 * @author Erding Israel Flores Moreno
 * @author Jefferson Alexis Del Barco Pilozo
 */
public abstract class Animal extends SerVivo {

    Palabra palabra;
    Pane pane;
    Timeline timeline;
    ArrayList<String> listaPalabras;
    Boolean murio = false;
    Boolean mato = false;
    MediaPlayer mediaPlayer;

    /**
     * Constructor de la clase Letra
     *
     * inicializa un panel
     *
     * @param imagen imagen del animal
     * @param layer panel en que se colocara al animal
     * @param x ubicacion que se desea en x
     * @param y ubicacion que se desea en y
     * @param vidas cantidad de vidas
     * @param speed velocidad de movimiento
     * @param palabras palabra que tendra el animal encima
     */
    public Animal(Image imagen, Pane layer, double x, double y, int vidas, double speed, ArrayList<String> palabras) {
        super(imagen, layer, x, y, vidas, speed);
        this.imageView.relocate(x, y);
        this.addLayer();
        this.listaPalabras = palabras;
        setupLabel();
        setupTimeline();
        Media hit = new Media(new File("fuego.wav").toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
    }

    /**
     * metodo abstracto getpuntos
     *
     * @return la cantidad de puntos que tendra el animal
     */
    public abstract int getpuntos();

    /**
     * metodo getPane
     *
     *
     * @return regresael pane en que se enceutra al animal
     */
    public Pane getPane() {
        return pane;
    }

    /**
     * Metodo setupTimeline pone en marcha los diferentes Keyframe que se
     * encuentran dentro
     */
    public void setupTimeline() {
        KeyFrame kf = new KeyFrame(Duration.millis(100), new TimeHandler());
        timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    /**
     * clase interna TimeHAndler que implemtana la interface eventHandler que es
     * un keyframe del metodo setupTimeline y su metodo handle verifica si el
     * animal a mordido o no al buceador
     *
     *
     */
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

    /**
     * metodo stop detiene el keyframe
     *
     *
     */
    public void stop() {
        this.timeline.stop();
    }

    /**
     * metodo play reprioduce el metodo setupTimeline
     *
     *
     */
    public void play() {
        this.timeline.play();
    }
  /**
     * metodo play reprioduce el metodo setupTimeline
     *
     *
     * @return regresa elestado de vida del animal
     * 
     */
    public Boolean getMurio() {
        return murio;
    }
  /**
     * metodo setMurio
     *
     *
     * @param murio setea el estado del animla si mmurio o no
     */
    public void setMurio(Boolean murio) {
        this.murio = murio;
    }
  /**
     * metodo setupLabel 
     * poen el label de la palabras encima de animal
     *
     *
     */
    public void setupLabel() {
        if (!this.listaPalabras.isEmpty()) {
            palabra = new Palabra(this.listaPalabras.get(0));
            this.layer.getChildren().add(palabra.getPane());
        }
    }
  /**
     * metodo getMato
     *
     *
     * @return regresa true si el animal mato al buceador
     */
    public Boolean getMato() {
        return mato;
    }
  /**
     * metodo setMato
     *
     *
     * @param mato setea el estado si a matado o no
     */
    public void setMato(Boolean mato) {
        this.mato = mato;
    }
  /**
     * metodo aumentarVelocidad
     * aumenta la velocidad con que se  mueven el objeto
     * esto pasa cuando se equivocan en el ingreso de las letras a ala palbra
     *
     *
     */
    public void aumentarVelocidad() {
        this.speed = this.speed + 2;
    }
  /**
     * metodo removePalabra quita la palabra del animal si esta palabrta ya fue completada
     *
     *
     */
    public void removePalabra() {
        this.layer.getChildren().remove(this.palabra.getPane());
        if (this.vidas == 0) {

            this.timeline.stop();
        }
    }
  /**
     * metodo matarAnimal
     * elmina a un animal de la vantana
     *
     *
     */
    public void matarAnimal() {
        mediaPlayer.setAutoPlay(true);
        removeBicho();
        removePalabra();
        this.murio = true;
        
    }
  /**
     * metodo inputLetras
     *
     *
     * @param code ingres la letra a la palabras y verifica
     */
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
                matarAnimal();
                this.listaPalabras.remove(0);
            } else {
                this.murio = true;
                removePalabra();
                this.listaPalabras.remove(0);
                setupLabel();
            }

        }
    }
  /**
     * metodo setup
     * si se tiene varias vidas este metodo pone la siguiente palabras encima del animal
     *
     *
     */
    public void setup() {
        //this.palabra.getPane().relocate(imageView.getLayoutX() + imageView.getFitWidth() / 2, y + 50);
        this.palabra.getPane().relocate(imageView.getLayoutX() + (this.getHeight() * 0.25 / 4), imageView.getLayoutY() + (this.getWidth() * 0.25 / 5));
    }

}
