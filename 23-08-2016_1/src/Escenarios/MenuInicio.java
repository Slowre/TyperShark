/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escenarios;

import Constantes.Settings;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Flores
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
    }

    public StackPane getget() {
        return this.rootPane;
    }

    public Boolean getPlay() {
        return play;
    }

    public void setPlay(Boolean play) {
        this.play = play;
    }

    public Boolean getScore() {
        return score;
    }

    public void setScore(Boolean score) {
        this.score = score;
    }

    public Boolean getInstruction() {
        return instruction;
    }

    public void setInstruction(Boolean instruction) {
        this.instruction = instruction;
    }

    public Boolean getExit() {
        return exit;
    }

    public void setExit(Boolean exit) {
        this.exit = exit;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

}
