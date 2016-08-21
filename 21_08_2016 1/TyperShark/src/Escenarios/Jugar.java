/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escenarios;

import Constantes.Settings;
import Palabras.Diccionario;
import Personajes.Animal;
import Personajes.Buceador;
import Personajes.Piraña;
import Personajes.Tiburon;
import Personajes.TiburonNegro;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.util.Duration;

/**
 *
 * @author Flores
 */
public class Jugar {

    Boolean state = true;
    Random rnd = new Random();
    ArrayList<Animal> tiburones = new ArrayList<Animal>();
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
    Text scoreText = new Text();
    Text arma = new Text();
    Text stage = new Text();
    int porcentajeArma = 0;
    int puntos = 0;
    int round = 1;
    Boolean checkStage = false;
    Timeline timeline;
    Timeline timeline2;

    public Jugar() {
        cargarImagenes();
        diccionario = new Diccionario();
        pane1 = new Pane();
        pane1.addEventFilter(KeyEvent.KEY_PRESSED, new teclado());
        _root = new BorderPane();
        musica();
    }

    public void Inicio() {
        hacerBuceadores();
        pane1.setFocusTraversable(true);
        _root.setCenter(pane1);
        setupScore();
        setupArma();

        mediaPlayer.setAutoPlay(true);
        Image fondo = new Image("file:fondo-del-mar-189765.jpg");
        ImageView imageView3 = new ImageView();
        imageView3.setImage(fondo);
        imageView3.setFitHeight(fondo.getHeight() * 0.5);
        imageView3.setFitWidth(fondo.getWidth() * 0.5);
        rootPane.getChildren().addAll(imageView3, this.getRoot());
        setupStage();
        setupTimeline();
        setupTimeline2();
    }

    public Buceador getBuceador() {
        return buceador;
    }
    

    public void fin() {
        pane1.setFocusTraversable(false);
        detener();

        mediaPlayer.stop();
        timeline.stop();
        timeline2.stop();

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

    public void setupScore() {
        scoreText.setFont(Font.font(null, FontWeight.BOLD, 64));
        scoreText.setStroke(Color.BLACK);
        scoreText.setFill(Color.RED);
        scoreText.relocate(100 + 150, 100 + 60);
        scoreText.setBoundsType(TextBoundsType.VISUAL);

        _root.setRight(scoreText);
    }

    public void setupArma() {
        arma.setFont(Font.font(null, FontWeight.BOLD, 64));
        arma.setStroke(Color.WHITE);
        arma.setFill(Color.BLUE);
        arma.relocate(100 + 150, 100 + 60);
        arma.setBoundsType(TextBoundsType.VISUAL);
        _root.setBottom(arma);
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
        this.buceador = buceador;
    }

    private void hacerPirañas() {
        Image image = piraña;
        double speed = rnd.nextDouble() * 1.0 + 2.0;
        double x = 0;
        ArrayList<String> palabras = new ArrayList();
        palabras.add(this.diccionario.getPalabra(Boolean.TRUE));
        double y = (Settings.SCENE_HEIGHT - (piraña.getHeight() * 0.25)) * rnd.nextDouble();
        Piraña enemy = new Piraña(image, pane1, Settings.SCENE_WIDTH, y, 1, speed, palabras);
        tiburones.add(enemy);
    }

    private void hacerTiburones() {
        Image image = tiburon;
        double speed = rnd.nextDouble() * 1.0 + 2.0;
        double x = 0;
        ArrayList<String> palabras = new ArrayList();
        palabras.add(this.diccionario.getPalabra(Boolean.FALSE));
        double y = (Settings.SCENE_HEIGHT - (tiburon.getHeight() * 0.25)) * rnd.nextDouble();
        Tiburon enemy = new Tiburon(image, pane1, Settings.SCENE_WIDTH, y, 1, speed, palabras);
        tiburones.add(enemy);
    }

    private void hacerTiburonesNegros() {
        Image image = tiburon_negro;
        double speed = rnd.nextDouble() * 1.0 + 2.0;
        double x = 0;
        ArrayList<String> palabras = new ArrayList();
        int vidas = rnd.nextInt(2) + 2;
        for (int i = 0; i <= vidas; i++) {
            palabras.add(this.diccionario.getPalabra(Boolean.FALSE));
        }
        double y = (Settings.SCENE_HEIGHT - (tiburon_negro.getHeight() * 0.25)) * rnd.nextDouble();
        TiburonNegro enemy = new TiburonNegro(image, pane1, Settings.SCENE_WIDTH, y, vidas, speed, palabras);
        tiburones.add(enemy);
    }

    public void musica() {
        Media hit = new Media(new File("kk.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
    }

    public void lanzarArma() {
        timeline.pause();

        while (!tiburones.isEmpty()) {
            puntaje = tiburones.get(0).getpuntos();
            tiburones.get(0).setVidas(0);
            tiburones.get(0).matarAnimal();
            removerAnimal();

        }
        timeline.play();

    }

    public void setupStage() {
        stage.setFont(Font.font(null, FontWeight.BOLD, 64));
        stage.setStroke(Color.BLACK);
        stage.setFill(Color.RED);
        stage.relocate(100 + 150, 100 + 60);
        stage.setBoundsType(TextBoundsType.VISUAL);
        rootPane.getChildren().add(stage);
        stage.setText("Round " + round);

    }

    public void detener() {
        if (!tiburones.isEmpty()) {
            for (Animal animal : tiburones) {
                animal.stop();

            }
        }
    }

    public void removerAnimal() {
        if (tiburones.get(0).getVidas() == 0) {
            this.buceador.setPuntaje(puntaje);
            puntos = puntos + puntaje;
            puntaje = 0;
            tiburones.remove(0);
        }
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void setupTimeline() {
        KeyFrame kf1 = new KeyFrame(Duration.millis(50), new TimeHandler1());
        KeyFrame kf2 = new KeyFrame(Duration.millis(50), new TimeHandler2());
        KeyFrame kf3 = new KeyFrame(Duration.millis(50), new TimeHandler3());
        KeyFrame kf4 = new KeyFrame(Duration.millis(50), new TimeHandler4());
        timeline = new Timeline(kf1, kf2, kf3, kf4);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private class TimeHandler1 implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            if (buceador.getVidas() == 0) {

                state = false;
                fin();
            }
            if (!tiburones.isEmpty()) {
                if (tiburones.get(0).getMato()) {
                    tiburones.get(0).setMato(false);
                    tiburones.get(0).matarAnimal();
                    buceador.setVidas(buceador.getVidas() - 1);
                }
            }
        }
    }

    private class TimeHandler2 implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            int posi = rnd.nextInt(100);
            if (posi == 25) {
                int ani = rnd.nextInt(3);
                switch (ani) {
                    case 0:
                        hacerPirañas();
                        break;
                    case 1:
                        hacerTiburones();
                        break;
                    case 2:
                        hacerTiburonesNegros();
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private class TimeHandler3 implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            System.out.println(round);
            arma.setText(String.valueOf(porcentajeArma) + "%");
            porcentajeArma++;
            if (porcentajeArma > 100) {
                porcentajeArma = 100;
            }
            scoreText.setText(String.valueOf(buceador.getPuntaje()));
        }
    }

    private class TimeHandler4 implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (mediaPlayer.getCurrentCount() == 1) {
                mediaPlayer.stop();
                mediaPlayer.play();
            }
        }
    }

    public void setupTimeline2() {

        KeyFrame kf5 = new KeyFrame(Duration.millis(200), new TimeHandler5());
        timeline2 = new Timeline(kf5);
        timeline2.setCycleCount(Animation.INDEFINITE);
        timeline2.play();
    }

    private class TimeHandler5 implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (puntos < 100) {

                stage.setText("");
            }
            if (puntos >= 100) {
                round++;
                puntos = 0;
                stage.setText("Round " + round);

            }
        }
    }

    class teclado implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent event) {
            switch (event.getCode()) {
                case ENTER:
                    if (porcentajeArma == 100) {
                        System.out.println("los mate a todos");
                        lanzarArma();
                        porcentajeArma = 0;
                    }
                    break;
                default:
                    if (!tiburones.isEmpty()) {
                        if (tiburones.get(0) instanceof Tiburon) {
                            Tiburon tiqui = (Tiburon) tiburones.get(0);
                            tiqui.inputLetras(event.getCode().getName());
                            puntaje = tiqui.getpuntos();
                        }
                        if (tiburones.get(0) instanceof Piraña) {
                            Piraña tiqui = (Piraña) tiburones.get(0);
                            tiqui.inputLetras(event.getCode().getName());
                            puntaje = tiqui.getpuntos();
                        }
                        if (tiburones.get(0) instanceof TiburonNegro) {
                            TiburonNegro tiqui = (TiburonNegro) tiburones.get(0);
                            tiqui.inputLetras(event.getCode().getName());
                            puntaje = tiqui.getpuntos();
                            if (tiqui.getMurio()) {
                                tiqui.setup();
                            }
                            tiqui.setMurio(false);
                        }
                        removerAnimal();
                    }
                    break;

            }
        }
    }
}
