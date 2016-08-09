/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebatiburones;

import Escenarios.Jugar;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Flores
 */
public class SceneOrganizer {
    Scene scene;
    Jugar jugar;

    public SceneOrganizer() {
        jugar=new Jugar();
        scene = new Scene(jugar.getRoot(), Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
       // scene.addEventFilter(KeyEvent.KEY_PRESSED, new teclado());
        
    }

    public Scene getScene() {
        return scene;
    }
//    final class teclado implements EventHandler<KeyEvent> {
//
//        @Override
//        public void handle(KeyEvent event) {
//            System.out.println("KKK");
//            
//        }
//    }
    
}
