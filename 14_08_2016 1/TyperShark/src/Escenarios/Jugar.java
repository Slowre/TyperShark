/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escenarios;

import Constantes.Settings;
import Palabras.Diccionario;
import Personajes.Buceador;
import Personajes.Piraña;
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
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
import javafx.util.Duration;
//import javafx.scene.effect.;

/**
 *
 * @author Flores
 */
public class Jugar {

    Boolean state = true;
    Random rnd = new Random();
    ArrayList<SpriteBase> tiburones = new ArrayList<>();
    private BorderPane _root;
    Scene scene;
    Pane pane1;
    Image tiburon;
    Image tiburon_negro;
    Image playerImage;
    Image piraña;
    int puntaje = 0;
    int _distance = 2;
    MediaPlayer mediaPlayer;
    Diccionario diccionario;
    StackPane rootPane = new StackPane();
    Buceador buceador;

    public Jugar() {
        diccionario = new Diccionario();
        pane1 = new Pane();
        pane1.addEventFilter(KeyEvent.KEY_PRESSED, new teclado());
        _root = new BorderPane();
        musica();
    }

    public void Inicio() {
        cargarImagenes();
        hacerTiburones();
        hacerPirañas();
        hacerBuceadores();
        pane1.setFocusTraversable(true);
        _root.setCenter(pane1);
        setupTimeline();
        
        mediaPlayer.setAutoPlay(true);
        Image fondo = new Image("file:fondo-del-mar-189765.jpg");
        ImageView imageView3 = new ImageView();
        imageView3.setImage(fondo);
        imageView3.setFitHeight(fondo.getHeight() * 0.5);
        imageView3.setFitWidth(fondo.getWidth() * 0.5);
        rootPane.getChildren().addAll(imageView3, this.getRoot());
    }
    public void fin(){
    pane1.setFocusTraversable(false);
    mediaPlayer.stop();
    
    }

    public StackPane getget() {
        return this.rootPane;
    }

    public BorderPane getRoot() {
        return _root;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public void cargarImagenes() {
        playerImage = new Image("file:isra.png");
        tiburon_negro = new Image("file:blue_shark_02_by_wolverine041269-d60qpvs.png");
        piraña = new Image("file:pirania.gif");
        tiburon = new Image("file:tiburon.gif");
    }

    private void hacerBuceadores() {
        Image image = playerImage;
        double speed = rnd.nextDouble() * 1.0 + 2.0;
        double x = 0;
        double y = 0;
        Buceador buceador = new Buceador(image, pane1, 0, y, 1, 0);
        this.buceador=buceador;
    }

    private void hacerPirañas() {
        Image image = piraña;
        double speed = rnd.nextDouble() * 1.0 + 2.0;
        double x = 0;
        double y = (Settings.SCENE_HEIGHT - (piraña.getHeight() * 0.25)) * rnd.nextDouble();
        Piraña enemy = new Piraña(image, pane1, Settings.SCENE_WIDTH, y, 1, speed, this.diccionario.getPalabra(Boolean.TRUE));
        tiburones.add(enemy);
    }

    private void hacerTiburones() {
        Image image = tiburon;
        double speed = rnd.nextDouble() * 1.0 + 2.0;
        double x = 0;
        double y = (Settings.SCENE_HEIGHT - (tiburon.getHeight() * 0.25)) * rnd.nextDouble();
        Tiburon enemy = new Tiburon(image, pane1, Settings.SCENE_WIDTH, y, 1, speed, this.diccionario.getPalabra(Boolean.FALSE));
        tiburones.add(enemy);
    }

    private void hacerTiburonesNegros() {
        Image image = tiburon_negro;
        double speed = rnd.nextDouble() * 1.0 + 2.0;
        double x = 0;
        double y = (Settings.SCENE_HEIGHT - (tiburon_negro.getHeight() * 0.25)) * rnd.nextDouble();
        Piraña enemy = new Piraña(image, pane1, Settings.SCENE_WIDTH, y, 1, speed, this.diccionario.getPalabra(Boolean.FALSE));
        tiburones.add(enemy);
    }

    public void musica() {
        Media hit = new Media(new File("kk.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
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
            if (mediaPlayer.getCurrentCount() == 1) {
                mediaPlayer.stop();
                mediaPlayer.play();
            }
            for (SpriteBase tibu : tiburones) {
                if (tibu.getVidas() == 0) {
                    System.out.println("FINNN");
                }
                if (tibu instanceof Tiburon) {
                    Tiburon tiqui = (Tiburon) tibu;
                    //tiqui.getPane().setFocusTraversable(true);
                }
            }
            if(buceador.getVidas()==0)
                state=false;
        }
    }

    public void removerAnimal() {
        if (tiburones.get(0).getVidas() == 0) {
            tiburones.remove(0);
        }
    }

    class teclado implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent event) {
            switch (event.getCode()) {
                case ENTER:
                    System.out.println("los mate a todos");
                    break;
                default:
                    if (!tiburones.isEmpty()) {
                        if (tiburones.get(0) instanceof Tiburon) {
                            Tiburon tiqui = (Tiburon) tiburones.get(0);
                            tiqui.inputLetras(event.getCode().getName());
                        }
                        if (tiburones.get(0) instanceof Piraña) {
                            Piraña tiqui = (Piraña) tiburones.get(0);
                            tiqui.inputLetras(event.getCode().getName());
                        }
                        removerAnimal();
                    }
                    break;

            }
        }
    }
}
