/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasprite;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Flores
 */
public class PruebaSprite extends Application {

    private static final Image IMAGE = new Image("file:pp.png");

    int COLUMNS = 2;
    int COUNT = 5;
    int OFFSET_X = 30;
    int OFFSET_Y = 0;
    int WIDTH = 593;
    int HEIGHT = 335;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        OFFSET_X = 30 / 4;
        OFFSET_Y = 0;
        WIDTH = 593 / 4;
        HEIGHT = 335 / 4;
        primaryStage.setTitle("The Horse in Motion");

        ImageView imageView = new ImageView(IMAGE);
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
        //imageView.setFitHeight(IMAGE.getHeight() * 0.25);
        //imageView.setFitWidth(IMAGE.getWidth() * 0.25);
//        AnimationTimer gameLoop = new AnimationTimer() {
//            private int _distance = 10;
//
//            @Override
//            public void handle(long now) {
//                imageView.setLayoutX(imageView.getLayoutX() + _distance);
//
//            }
//
//        };
//        gameLoop.start();
        final Animation animation = new SpriteAnimation(
                imageView,
                Duration.millis(1000),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: BLACK;");
        pane.getChildren().add(imageView);
        // primaryStage.setScene(new Scene(new Group(imageView)));
        primaryStage.setScene(new Scene(pane, 300, 250));
        primaryStage.show();
    }
}
