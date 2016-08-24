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
import Recursos.HiloBuceador;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
 * Clase Mar que pose Animales y buceador
 *
 * @author Erding Israel Flores Moreno
 * @author Jefferson Alexis Del Barco Pilozo
 */
public class Mar {

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
    Text vidas = new Text();
    Text arma = new Text();
    Text stage = new Text();
    Text turno = new Text();
    int porcentajeArma = 0;
    int puntos = 0;
    int puntosParaVida = 0;
    int round = 1;
    Boolean checkStage = false;
    Timeline timeline;
    Timeline timeline2;
    HiloBuceador hilo;
    HBox marcador;
    int speed = 0;

    /**
     * Constructor de la clase Mar inicializa algunos de los paneles y objetos
     */
    public Mar() {
        marcador = new HBox();
        cargarImagenes();
        diccionario = new Diccionario();
        pane1 = new Pane();
        pane1.addEventFilter(KeyEvent.KEY_PRESSED, new teclado());
        _root = new BorderPane();
        musica();
    }

    /**
     * Metodo inicio Hace arrancar el juego
     */
    public void Inicio() {
        hacerBuceadores();
        pane1.setFocusTraversable(true);
        _root.setCenter(pane1);
        mediaPlayer.setAutoPlay(true);
        Image fondo = new Image("file:fondo-del-mar-189765.jpg");
        ImageView imageView3 = new ImageView();
        imageView3.setImage(fondo);
        imageView3.setFitHeight(fondo.getHeight() * 0.5);
        imageView3.setFitWidth(fondo.getWidth() * 0.5);
        rootPane.getChildren().addAll(imageView3, _root);
        setupStage();
        setupTimeline();
        setupTimeline2();
        setupMarcador();
    }

    /**
     * metodo setupMarcador crea el marcador de puntajes del jugador
     */
    public void setupMarcador() {
        vidas.setFont(Font.font(null, FontWeight.BOLD, 20));
        vidas.setStroke(Color.BLACK);
        vidas.setFill(Color.WHITE);
        vidas.setBoundsType(TextBoundsType.VISUAL);

        scoreText.setFont(Font.font(null, FontWeight.BOLD, 20));
        scoreText.setStroke(Color.BLACK);
        scoreText.setFill(Color.WHITE);
        scoreText.setBoundsType(TextBoundsType.VISUAL);

        arma.setFont(Font.font(null, FontWeight.BOLD, 20));
        arma.setStroke(Color.BLACK);
        arma.setFill(Color.WHITE);
        arma.setBoundsType(TextBoundsType.VISUAL);

        turno.setFont(Font.font(null, FontWeight.BOLD, 20));
        turno.setStroke(Color.BLACK);
        turno.setFill(Color.WHITE);
        turno.setBoundsType(TextBoundsType.VISUAL);
        this.marcador.getChildren().addAll(vidas, scoreText, arma, turno);
        this.marcador.setAlignment(Pos.TOP_CENTER);
        this.marcador.setSpacing(100);
        _root.setTop(this.marcador);
    }

    /**
     * Metodo getBuceador obtine al buceador
     *
     * @return buceador
     */
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

    /**
     * Metodo getget
     *
     * @return el StackPane donde estan todos los paneles
     */
    public StackPane getget() {
        return this.rootPane;
    }

    /**
     * Metodo getget
     *
     * @return true or false se panel esta activo o inactivo
     */
    public Boolean getState() {
        return state;
    }

    /**
     * Metodo setState setea el estado del panel
     *
     * @param state Boolean estado del panel
     */
    public void setState(Boolean state) {
        this.state = state;
    }

    /**
     * Metodo cargarImagenes carga las imagenes de los diferentes personajes
     *
     */
    public void cargarImagenes() {
        playerImage = new Image("file:isra.png");
        tiburon_negro = new Image("file:blue_shark_02_by_wolverine041269-d60qpvs.png");
        piraña = new Image("file:pirania.gif");
        tiburon = new Image("file:tiburon.gif");
    }

    /**
     * Metodo hacerBuceadores crea un objeto tipo buceador y lo añade al panel e
     * inicia el hilobuceador
     *
     */
    private void hacerBuceadores() {
        Image image = playerImage;
        Buceador buceador = new Buceador(image, pane1, 0, 0, 3, 0);
        this.buceador = buceador;
        hilo = new HiloBuceador(buceador);
        hilo.start();
    }

    /**
     * Metodo hacerPirañas crea un abjeto tipo piraña , lo añade al panel y a
     * una lista de animales de la claase mar
     *
     */
    private void hacerPirañas() {
        Image image = piraña;
        double speed = rnd.nextDouble() * 1.0 + 2.0 + this.speed;
        double x = 0;
        ArrayList<String> palabras = new ArrayList();
        palabras.add(this.diccionario.getPalabra(Boolean.TRUE));
        double y = (Settings.SCENE_HEIGHT - (piraña.getHeight() * 0.25)) * rnd.nextDouble();
        Piraña enemy = new Piraña(image, pane1, Settings.SCENE_WIDTH, y, 1, speed, palabras);
        tiburones.add(enemy);
    }

    /**
     * Metodo hacerTiburones crea un objeto tipo tiburon , lo añade al panel y a
     * una lista de animales de la claase mar
     *
     */
    private void hacerTiburones() {
        Image image = tiburon;
        double speed = rnd.nextDouble() * 1.0 + 2.0 + this.speed;
        double x = 0;
        ArrayList<String> palabras = new ArrayList();
        palabras.add(this.diccionario.getPalabra(Boolean.FALSE));
        double y = (Settings.SCENE_HEIGHT - (tiburon.getHeight() * 0.25)) * rnd.nextDouble();
        Tiburon enemy = new Tiburon(image, pane1, Settings.SCENE_WIDTH, y, 1, speed, palabras);
        tiburones.add(enemy);
    }

    /**
     * Metodo hacerTiburonesNegros crea un objeto tipo tiburon negro , lo añade
     * al panel y a una lista de animales de la claase mar
     *
     */
    private void hacerTiburonesNegros() {
        Image image = tiburon_negro;
        double speed = rnd.nextDouble() * 1.0 + 2.0 + this.speed;
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

    /**
     * Metodo musica hace una instancia del objeto mediaplayer para reproducir
     * una cancion
     *
     */
    public void musica() {
        Media hit = new Media(new File("kk.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
    }

    /**
     * Metodo lanzarArma mata a todos los tiburenoes en el panel agregando la
     * puntuacion al buceador
     *
     */
    public void lanzarArma() {
        while (!tiburones.isEmpty()) {
            puntaje = tiburones.get(0).getpuntos();
            tiburones.get(0).setVidas(0);
            tiburones.get(0).matarAnimal();
            removerAnimal();

        }
    }

    /**
     * Metodo tempHilo pone los puntos por round al buceador para que el hilo
     * siga su movimiento
     *
     */
    public void tempHilo() {

        this.buceador.setPuntosRound(puntos);
    }

    /**
     * Metodo setupStage pone la señal de cambio de roaund en medio de la
     * pantalla
     *
     */
    public void setupStage() {
        stage.setFont(Font.font(null, FontWeight.BOLD, 64));
        stage.setStroke(Color.BLACK);
        stage.setFill(Color.RED);
        stage.relocate(100 + 150, 100 + 60);
        stage.setBoundsType(TextBoundsType.VISUAL);
        rootPane.getChildren().add(stage);
        stage.setText("Round " + round);

    }

    /**
     * Metodo detener detiene a todos los animales
     *
     */
    public void detener() {
        if (!tiburones.isEmpty()) {
            for (Animal animal : tiburones) {
                animal.stop();

            }
        }
    }

    /**
     * Metodo removerAnimal remueve al primer animal de la lista dando su
     * puntaje al buceador y amuentado los puntos para tener una vida extra
     */
    public void removerAnimal() {
        if (tiburones.get(0).getVidas() == 0) {
            this.buceador.setPuntaje(puntaje);

            puntos = puntos + puntaje;
            puntosParaVida = puntosParaVida + puntos;
            puntaje = 0;
            tiburones.remove(0);
        }

    }

    /**
     * Metodo setupTimeline pone en marcha los diferentes Keyframe que se
     * encuentran dentro
     */
    public void setupTimeline() {
        KeyFrame kf1 = new KeyFrame(Duration.millis(50), new CheckVida());
        KeyFrame kf2 = new KeyFrame(Duration.millis(50), new CrearAnimal());
        KeyFrame kf3 = new KeyFrame(Duration.millis(50), new LabelsArmaPuntaje());
        KeyFrame kf4 = new KeyFrame(Duration.millis(50), new RepetirMusica());
        timeline = new Timeline(kf1, kf2, kf3, kf4);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    /**
     * Clase interna CheckVida implementa la interface EventHAndler que es un
     * keyFrame de setupTimeline cuyo metodo handle verifica la vida del
     * buceador y tambien si los animales an mordido al buceador
     */
    private class CheckVida implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (buceador.getVidas() == 0) {

                state = false;
                fin();
            }
            if (!tiburones.isEmpty()) {
                if (tiburones.get(0).getMato()) {
                    tiburones.get(0).stop();
                    tiburones.get(0).setMato(false);
                    tiburones.get(0).matarAnimal();
                    if (tiburones.get(0) instanceof Piraña) {
                        buceador.setNumpirañas(buceador.getNumpirañas() + 1);
                    } else {
                        buceador.setVidas(buceador.getVidas() - 1);
                    }
                    if (buceador.getNumpirañas() == 3) {
                        buceador.setVidas(buceador.getVidas() - 1);
                    }
                    tiburones.remove(0);
                }
            }
        }
    }

    /**
     * Clase interna CrearAnimal implementa la interface EventHAndler que es un
     * keyFrame de setupTimeline cuyo metodo handle crea uno de los tres
     * animales de forma aleatoria
     */
    private class CrearAnimal implements EventHandler<ActionEvent> {

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

    /**
     * Clase interna LabelsArmaPuntaje implementa la interface EventHAndler que
     * es un keyFrame de setupTimeline cuyo metodo handle actualiza el contenido
     * del marcador del jugador
     */
    private class LabelsArmaPuntaje implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            vidas.setText("Vidas: " + String.valueOf(buceador.getVidas()));
            arma.setText("Arma especial al " + String.valueOf(porcentajeArma) + "%");
            turno.setText("Round: " + round);
            porcentajeArma++;
            if (porcentajeArma > 100) {
                porcentajeArma = 100;
            }
            scoreText.setText("Score: " + String.valueOf(buceador.getPuntaje()));
        }
    }

    /**
     * Clase interna RepetirMusica implementa la interface EventHAndler que es
     * un keyFrame de setupTimeline cuyo metodo handle repite la cancion si esta
     * se acabo
     */
    private class RepetirMusica implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (mediaPlayer.getCurrentCount() == 1) {
                mediaPlayer.stop();
            }
            mediaPlayer.play();
        }
    }

    /**
     * Metodo setupTimeline2 pone en marcha los diferentes Keyframe que se
     * encuentran dentro
     */
    public void setupTimeline2() {

        KeyFrame kf5 = new KeyFrame(Duration.millis(200), new CambioDeRound());
        KeyFrame kf6 = new KeyFrame(Duration.millis(200), new VidaExtra());
        timeline2 = new Timeline(kf5, kf6);
        timeline2.setCycleCount(Animation.INDEFINITE);
        timeline2.play();
    }

    /**
     * Clase interna VidaExtra implementa la interface EventHAndler que es un
     * keyFrame de setupTimeline2 cuyo metodo handle verifica un puntaje
     * especifico para ver si se le regala una vida al buceador
     */
    private class VidaExtra implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (puntosParaVida > 1500) {
                buceador.setVidas(buceador.getVidas() + 1);
                puntosParaVida = 0;
            }
        }
    }

    /**
     * Clase interna CambioDeRound implementa la interface EventHAndler que es
     * un keyFrame de setupTimeline2 cuyo metodo handle cambia al sigueinte
     * raound si se completo el puntaje del round actual
     */
    private class CambioDeRound implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            tempHilo();
            if (puntos < 100) {

                stage.setText("");
            }
            if (puntos >= 1000) {
                round++;
                puntos = 0;
                stage.setText("Round " + round);
                buceador.setPuntosRound(0);
                // speed = speed + 1;
            }
            if (!hilo.isAlive()) {
                buceador.setPuntosRound(0);
                hilo.start();
            }
        }
    }

    /**
     * Clase interna teclado implementa la interface EventHAndler cuyo metodo
     * handle reacciona por la entrada por teclado al panel con enter para el
     * arma especial y las emas teclas para entregarlas al priumer aninal de la
     * lista y verificar y matar si es debido
     */
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
