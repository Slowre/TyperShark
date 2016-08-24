/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escenarios;

import Constantes.Settings;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Clase MenuInicio posee imagenes y paneles para presentar el muneinical del
 * juego
 *
 * @author Erding Israel Flores Moreno
 * @author Jefferson Alexis Del Barco Pilozo
 */
public class MenuInicio {

    Boolean state = false;
    Boolean play = false;
    Boolean score = false;
    Boolean instruction = false;
    Boolean exit = false;
    Image bPlay;
    Image bScore;
    Image bInstruction;
    Image bExit;
    Image fondo;
    ImageView b1;
    ImageView b2;
    ImageView b3;
    ImageView b4;
    ImageView imageViewFondo;
    private BorderPane _root;
    StackPane rootPane = new StackPane();

    /**
     * Constructor de la clase MenuInicio
     *
     * inicializa y ubica todos los panles imagenes y acciones de ellos
     */
    public MenuInicio() {
        _root = new BorderPane();
        Pane pane = new Pane();
        VBox vBox = new VBox();
        bPlay = new Image("file:Play.png");
        bScore = new Image("file:Score.png");
        bInstruction = new Image("file:Instructions.png");
        bExit = new Image("file:Exit.png");
        this.b1 = new ImageView(bPlay);
        b1.setFitHeight(bPlay.getHeight() * 0.3);
        b1.setFitWidth(bPlay.getWidth() * 0.3);
        b1.setOnMousePressed(e -> {
            b1.setImage(new Image("file:Playn.png"));
        });
        b1.setOnMouseReleased(e -> {
            b1.setImage(bPlay);
            this.play = true;

        });
        this.b2 = new ImageView(bScore);
        b2.setFitHeight(bPlay.getHeight() * 0.3);
        b2.setFitWidth(bPlay.getWidth() * 0.3);
        b2.setOnMousePressed(e -> b2.setImage(new Image("file:Scoren.png")));
        b2.setOnMouseReleased(e -> {
            b2.setImage(bScore);
            this.score = true;
        });
        this.b3 = new ImageView(bInstruction);
        b3.setFitHeight(bPlay.getHeight() * 0.3);
        b3.setFitWidth(bPlay.getWidth() * 0.3);
        b3.setOnMousePressed(e -> b3.setImage(new Image("file:Instructionsn.png")));
        b3.setOnMouseReleased(e -> {
            b3.setImage(bInstruction);
            this.instruction = true;
        });
        this.b4 = new ImageView(bExit);
        b4.setFitHeight(bPlay.getHeight() * 0.3);
        b4.setFitWidth(bPlay.getWidth() * 0.3);
        b4.setOnMousePressed(e -> b4.setImage(new Image("file:Exitn.png")));
        b4.setOnMouseReleased(e -> {
            this.exit = true;
            b4.setImage(bExit);
        });
        vBox.getChildren().addAll(b1, b2, b3, b4);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(30);
        _root.setRight(vBox);
        fondo = new Image("file:Oceanos.png");
        imageViewFondo = new ImageView(fondo);
        imageViewFondo.setFitHeight(Settings.SCENE_HEIGHT);
        imageViewFondo.setFitWidth(Settings.SCENE_WIDTH);
        rootPane.getChildren().addAll(imageViewFondo, _root);
        integrantes();
    }

    /**
     * Metodo getget
     *
     * @return el panel Stack de esta clase
     */
    public StackPane getget() {
        return this.rootPane;
    }

    public void integrantes() {
        Label mensaje3 = new Label();
        mensaje3.setFont(Font.font(null, FontWeight.BOLD, 20));
        mensaje3.setTextFill(Color.ORANGE);
        mensaje3.setText("Integrantes");
        Label mensaje4 = new Label();
        mensaje4.setFont(Font.font(null, FontWeight.BOLD, 20));
        mensaje4.setTextFill(Color.WHITE);
        mensaje4.setText("Erding Israel Flores Moreno"+"\n" +"Jefferson Alexis Del Barco Pilozo");
        VBox inte=new VBox();
        inte.getChildren().addAll(mensaje3,mensaje4);
        inte.setAlignment(Pos.BOTTOM_LEFT);
        _root.setLeft(inte);

    }

    /**
     * Metodo getPlay
     *
     * @return true si se elige la opcion play
     */
    public Boolean getPlay() {
        return play;
    }

    /**
     * Metodo setPlay
     *
     * @param play setea el estado de la opcion play
     */
    public void setPlay(Boolean play) {
        this.play = play;
    }

    /**
     * Metodo getScore
     *
     * @return true si se elige la opcion Score
     */
    public Boolean getScore() {
        return score;
    }

    /**
     * Metodo setScore
     *
     * @param score setea el estado de la opcion score
     */
    public void setScore(Boolean score) {
        this.score = score;
    }

    /**
     * Metodo getInstruction
     *
     * @return true si se elige la opcion Instrucciones
     */
    public Boolean getInstruction() {
        return instruction;
    }

    /**
     * Metodo setInstruction
     *
     * @param instruction setea el estado de la opcion instrucciones
     */
    public void setInstruction(Boolean instruction) {
        this.instruction = instruction;
    }

    /**
     * Metodo getExit
     *
     * @return true si se elige la opcion exit
     */
    public Boolean getExit() {
        return exit;
    }

    /**
     * Metodo setExit
     *
     * @param exit setea el estado de la opcion exit
     */
    public void setExit(Boolean exit) {
        this.exit = exit;
    }

    /**
     * Metodo getState
     *
     * @return true si la ventana esta activa
     */
    public Boolean getState() {
        return state;
    }

    /**
     * Metodo setState
     *
     * @param state setea el estado de la ventana
     */
    public void setState(Boolean state) {
        this.state = state;
    }

}
