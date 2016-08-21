/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escenarios;

import Constantes.Settings;
import Recursos.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

/**
 *
 * @author Flores
 */
public class PaneSave {

    StackPane rootPane = new StackPane();
    BorderPane principal;
    BorderPane secundario;
    private int puntaje;
    private String nombre;
    private String idTwitter;
    Label mensaje;
    VBox confirmarSave;
    VBox save;
    Boolean state = true;
    Timeline timeline;
    Label mensaje1;
    Label mensaje2;
    Image fondo;
    Image fondo1;
    ImageView imageViewFondo;
    ImageView imageViewFondo1;
    TextField txtnombre;
    TextField txtTwitter;
    Guardar guardar;
    Notificacion notificacion;

    public PaneSave() {

        principal = new BorderPane();
        secundario = new BorderPane();
        guardar = new Guardar();
        notificacion = new Notificacion();
        rootPane.setStyle("-fx-background-color: BLACK;");
        //principal.relocate((Settings.SCENE_HEIGHT/2)-principal.getMaxHeight()/2, (Settings.SCENE_WIDTH/2)-principal.getMaxWidth()/2);
        setupConfirmarSave();
        setupSave();
        setupTimeline();
    }

    public void setupConfirmarSave() {
        confirmarSave = new VBox();
        mensaje1 = new Label();
        mensaje1.setText("Usted a hecho la maxima puntuacion de \n" + this.puntaje + " desea guardar la partida?");
        mensaje1.setFont(Font.font(null, FontWeight.BOLD, 30));
        mensaje1.setTextFill(Color.WHITE);
        Pane pane = new Pane();
        confirmarSave.getChildren().add(mensaje1);
        HBox botones1 = new HBox();
        botones1.setSpacing(40);
        botones1.setAlignment(Pos.CENTER);
        Button b1 = new Button("Yes");
        Button b2 = new Button("No");
        b1.setOnAction(e -> {
            rootPane.getChildren().clear();
            
            rootPane.getChildren().addAll(pane, secundario);
        });
        b2.setOnAction(e -> {
            this.state = false;
        });
        botones1.getChildren().addAll(b1, b2);
        confirmarSave.getChildren().add(botones1);
        confirmarSave.setAlignment(Pos.BOTTOM_CENTER);
        confirmarSave.setSpacing(30);
        principal.setCenter(confirmarSave);
        fondo = new Image("file:Game_Over.jpg");
        imageViewFondo = new ImageView(fondo);
        imageViewFondo.setFitHeight(Settings.SCENE_HEIGHT - 100);
        imageViewFondo.setFitWidth(Settings.SCENE_WIDTH - 100);
        imageViewFondo.relocate((Settings.SCENE_WIDTH / 2) - (Settings.SCENE_WIDTH - 100) / 2, 0);
        pane.getChildren().add(imageViewFondo);
        rootPane.getChildren().addAll(pane, principal);

    }

    public void setupSave() {
        save = new VBox();
        Pane pane = new Pane();

        Label label1 = new Label("Nombre: ");
        label1.setTextFill(Color.WHITE);
        txtnombre = new TextField();
        txtnombre.setMinWidth(200);
        txtnombre.setMaxWidth(200);
        txtnombre.setPromptText("Ingrese su nombre");
        HBox nombreHBox = new HBox();
        nombreHBox.setSpacing(40);
        nombreHBox.setAlignment(Pos.CENTER);
        nombreHBox.getChildren().addAll(label1, txtnombre);

        save.getChildren().add(nombreHBox);

        Label label2 = new Label("ID twitter:");
        label2.setTextFill(Color.WHITE);
        txtTwitter = new TextField();
        txtTwitter.setMinWidth(200);
        txtTwitter.setMaxWidth(200);
        txtTwitter.setPromptText("Ingese su Id de twitter.");
        HBox twitterHBox = new HBox();
        twitterHBox.setSpacing(40);
        twitterHBox.setAlignment(Pos.CENTER);
        twitterHBox.getChildren().addAll(label2, txtTwitter);

        save.getChildren().add(twitterHBox);

        mensaje2 = new Label();
        mensaje2.setText("");
        mensaje2.setFont(Font.font(null, FontWeight.BOLD, 30));
        mensaje2.setTextFill(Color.RED);

        save.getChildren().add(mensaje2);

        HBox botones2 = new HBox();
        botones2.setSpacing(40);
        botones2.setAlignment(Pos.CENTER);
        Button b3 = new Button("Confirmar");
        Button b4 = new Button("Cancelar");
        b3.setOnAction(e -> {
            checkSave();
        });
         b4.setOnAction(e -> {
            this.state=false;
        });
        botones2.getChildren().addAll(b3, b4);
        save.getChildren().add(botones2);

        save.setSpacing(10);
        save.setAlignment(Pos.BOTTOM_CENTER);

        secundario.setCenter(save);

        fondo1 = new Image("file:Game_Over.jpg");
        imageViewFondo1 = new ImageView(fondo1);
        imageViewFondo1.setFitHeight(Settings.SCENE_HEIGHT - 100);
        imageViewFondo1.setFitWidth(Settings.SCENE_WIDTH - 100);
        imageViewFondo1.relocate((Settings.SCENE_WIDTH / 2) - (Settings.SCENE_WIDTH - 100) / 2, 0);
        pane.getChildren().add(imageViewFondo1);

        //rootPane.getChildren().addAll(pane,secundario);
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void opcion1() {
        principal.getChildren().clear();
        principal.getChildren().add(save);

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
            mensaje1.setText("Usted a hecho la maxima puntuacion de \n" + PaneSave.this.puntaje + " desea guardar la partida?");

        }

    }

    public StackPane getPane() {
        return this.rootPane;
    }

    public void checkSave() {
        if (this.txtnombre.textProperty().get().equals("")) {
            mensaje2.setText("Debe ingresar su nombre para poder grabar");
        } else {
            Jugador jugador = new Jugador(this.txtnombre.textProperty().get(), this.txtTwitter.textProperty().get(), this.puntaje);
            guardar.save(jugador);
            if (!this.txtTwitter.textProperty().get().equals("")) {
                notificacion.confirmacionTwitter(jugador);
            }
            this.state=false;
        };

    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

}
