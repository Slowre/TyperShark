/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import Constantes.Settings;
import Escenarios.Jugar;
import Escenarios.MenuInicio;
import Personajes.SpriteBase;
import Personajes.Tiburon;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 *
 * @author Flores
 */
public class SceneOrganizer {

    Scene scene;
    Jugar jugar;
    MenuInicio menuInicio;
    Boolean state=true;
    public SceneOrganizer() {
        jugar = new Jugar();
        menuInicio = new MenuInicio();
        menuInicio.setState(Boolean.TRUE);
        scene = new Scene(menuInicio.getget(), Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
        scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new input());
        
    }

    public Scene getScene() {
        return scene;
    }

    public Boolean getState() {
        return state;
    }
    
    private class input implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
             if (menuInicio.getState()) {
                if (menuInicio.getPlay()) {
                    menuInicio.setState(Boolean.FALSE);
                    jugar.setState(Boolean.TRUE);
                    jugar.Inicio();
                    scene.setRoot(jugar.getget());
                }
                if(menuInicio.getScore()){
                }
                if(menuInicio.getInstruction()){
                }
                if(menuInicio.getExit()){
                    state=false;
                }
            }
             if(!jugar.getState()){
                scene.setRoot(menuInicio.getget());
                jugar.setState(Boolean.TRUE);
             }

        }

    }

}
