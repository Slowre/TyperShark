/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebatiburones;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author Flores
 */
public class Tiburon extends SpriteBase {

    Palabra palabra;

    public Tiburon(Image imagen, Pane layer, double x, double y, double vidas, double speed) {
        super(imagen, layer, x, y, vidas, speed);
        this.imageView.relocate(x, y);
//        this.imageView.setX(100);
//        this.imageView.setY(100);

        this.imageView.setFitHeight(this.getHeight() * 0.25);
        this.imageView.setFitWidth(this.getWidth() * 0.25);
        
        this.addLayer();
        setupLabel("ABCDE");
        this.layer.addEventFilter(KeyEvent.KEY_PRESSED, new teclado());
        setupTimeline();
    }

    public void murio() {
        this.setVidas(0);
        if (this.getVidas() == 0) {
            //this.layer.getChildren().remove(this.imageView);
            //this.layer.getChildren().remove(palabra.getPane());
            try {
                // this.finalize();
            } catch (Throwable ex) {
                Logger.getLogger(Tiburon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setupTimeline() {
        KeyFrame kf = new KeyFrame(Duration.millis(100), new TimeHandler());
        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private class TimeHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            imageView.setLayoutX(imageView.getLayoutX() - speed);

            palabra.getPane().setLayoutX(palabra.getPane().getLayoutX() - speed);

        }

    }

    public void setupLabel(String cadena) {
        palabra = new Palabra(cadena);
        palabra.getPane().relocate(x+imageView.getLayoutX()* 0.25/2, y+50);
        this.layer.getChildren().addAll(palabra.getPane());

    }

    @Override
    public void alive() {

        if (Double.compare(getY(), Settings.SCENE_HEIGHT) > 0) {

        }

    }

    public void aumentarVelocidad() {
        this.speed = this.speed * 2;
    }

    class teclado implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent event) {
            switch (event.getCode()) {
                default:
                    palabra.input(event.getCode().getName());
                    if (!palabra.isCheckinput()) {
                        aumentarVelocidad();
                        palabra.setCheckinput(true);
                    }
                    if (palabra.checkPalabra()) {
                        System.out.println("ganaste");
                        murio();
                    }
                    break;

            }
        }
    }

}
