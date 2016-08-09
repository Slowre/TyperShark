/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escenarios;

import Personajes.Buceador;
import Personajes.Tiburon;
import Personajes.SpriteBase;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
import javafx.util.Duration;
import pruebatiburones.Settings;

/**
 *
 * @author Flores
 */
public class Jugar {

    Random rnd = new Random();
    List<Tiburon> tiburones = new ArrayList<>();
    private BorderPane _root;
    Scene scene;
    Pane pane1;
    Image enemyImage;
    Image playerImage;
    ImageView imageView1;
    ImageView imageView2;
    Text collisionText = new Text();
    int puntaje = 0;
    int _distance = 2;
    MediaPlayer mediaPlayer;

    public Jugar() {
        pane1 = new Pane();
        pane1.setFocusTraversable(true);
        _root = new BorderPane();
        cargarImagenes();
        hacerTiburones();
        hacerBuceadores();
        _root.setCenter(pane1);
        _root.setFocusTraversable(true);
        setupTimeline();
        musica();
    }

    public BorderPane getRoot() {
        return _root;
    }

    public void cargarImagenes() {
        playerImage = new Image("file:isra.png");
        enemyImage = new Image("file:blue_shark_02_by_wolverine041269-d60qpvs.png");

    }
    private void hacerBuceadores(){
     Image image = playerImage;

        double speed = rnd.nextDouble() * 1.0 + 2.0;

        double x = 0;
        double y = 0;

        Buceador buceador = new Buceador(image, pane1, 0, y, 1, 0);
    
    
    }

    private void hacerTiburones() {

        Image image = enemyImage;

        double speed = rnd.nextDouble() * 1.0 + 2.0;

        double x = 0;
        double y = 0;

        Tiburon enemy = new Tiburon(image, pane1, Settings.SCENE_WIDTH, y, 1, speed);

        // manage sprite
        tiburones.add(enemy);

    }

    public void musica() {
        Media hit = new Media(new File("kk.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.setAutoPlay(true);
        // mediaPlayer.play();
    }

    public void setupTimeline() {
        KeyFrame kf = new KeyFrame(Duration.millis(1000), new TimeHandler());
        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private class TimeHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            if (mediaPlayer.getCurrentCount() == 1) {
                mediaPlayer.stop();
                mediaPlayer.play();
            }
        }

    }

    public void removeTiburon() {

        Iterator<? extends SpriteBase> iter = tiburones.iterator();

        while (iter.hasNext()) {
            SpriteBase sprite = iter.next();
            System.out.println("Sprite vida:" + sprite.getVidas());
            if (sprite.getVidas() == 0) {
                iter.remove();

            }
        }
//    for(Tiburon tibu:this.tiburones){
//        this.pane1.getChildren().contains(tibu);
//    }
    }

}
