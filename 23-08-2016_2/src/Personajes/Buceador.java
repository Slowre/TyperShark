/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author Flores
 */
public class Buceador extends SpriteBase {

    int COLUMNS = 2;
    int COUNT = 5;
    int OFFSET_X = 30;
    int OFFSET_Y = 0;
    int WIDTH = 593;
    int HEIGHT = 335;
    int numPirañas=0;
    Animation animation;
    private int puntaje=0;
    private int puntosRound=0;
    public Buceador(Image imagen, Pane layer, double x, double y, double vidas, double speed) {
        super(imagen, layer, x, y, vidas, speed);
        ponerBuceador();
        this.addLayer();
        //setupTimeline();
    }

    public int getNumpirañas() {
        return numPirañas;
    }

    public void setNumpirañas(int numpirañas) {
        this.numPirañas = numpirañas;
    }

    public int getPuntosRound() {
        return puntosRound;
    }

    public void setPuntosRound(int puntosRound) {
        this.puntosRound = puntosRound;
    }
    

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = this.puntaje+puntaje;
    }
    

    public void ponerBuceador() {
        imageView.setFitHeight(imagen.getHeight() * 0.1);
        imageView.setFitWidth(imagen.getWidth() * 0.1);
        imageView.setLayoutY(200 - imageView.getFitHeight() / 2);
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));

         animation = new SpriteAnimation(
                imageView,
                Duration.millis(1000),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();

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
           
        }

    }

//    @Override
//    public void alive() {
//    }

    public class SpriteAnimation extends Transition {

        private final ImageView imageView;
        private final int count;
        private final int columns;
        private final int offsetX;
        private final int offsetY;
        private final int width;
        private final int height;

        private int lastIndex;

        public SpriteAnimation(
                ImageView imageView,
                Duration duration,
                int count, int columns,
                int offsetX, int offsetY,
                int width, int height) {
            this.imageView = imageView;

            this.count = count;
            this.columns = columns;
            this.offsetX = offsetX;
            this.offsetY = offsetY;
            this.width = width;
            this.height = height;
            setCycleDuration(duration);
            setInterpolator(Interpolator.LINEAR);
        }

        protected void interpolate(double k) {
            final int index = Math.min((int) Math.floor(k * count), count - 1);
            if (index != lastIndex) {
                final int x = (index % columns) * width + offsetX;
                final int y = (index / columns) * height + offsetY;
                imageView.setViewport(new Rectangle2D(x, y, width, height));
                lastIndex = index;
            }
        }
    }
}
