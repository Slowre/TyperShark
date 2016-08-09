/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebatiburones;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Flores
 */
public class PruebaTiburones extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      SceneOrganizer organizer = new SceneOrganizer();
        primaryStage.setScene(organizer.getScene());
        primaryStage.setTitle("MovingShape!");
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
    