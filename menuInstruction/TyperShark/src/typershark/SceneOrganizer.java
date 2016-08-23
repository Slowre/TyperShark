/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import Constantes.Settings;
import Escenarios.Jugar;
import Escenarios.MenuInicio;
import Escenarios.MostrarInstruction;
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
    MostrarInstruction mostrar;
    MenuInicio menuInicio;
    Boolean state = true;
    Timeline timeline;

    public SceneOrganizer() {
        jugar = new Jugar();
        mostrar = new MostrarInstruction();
        menuInicio = new MenuInicio();
        menuInicio.setState(Boolean.TRUE);
        scene = new Scene(menuInicio.getget(), Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
        //scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new input());
        setupTimeline();

    }

    public Scene getScene() {
        return scene;
    }

    public Boolean getState() {
        return state;
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
            if (menuInicio.getState()) {
                if (menuInicio.getPlay()) {
                    menuInicio.setState(Boolean.FALSE);
                    menuInicio.setPlay(Boolean.FALSE);
                    jugar.Inicio();
                    scene.setRoot(jugar.getget());
                }
                if (menuInicio.getScore()) {
                }
                if (menuInicio.getInstruction()) {
                    menuInicio.setState(Boolean.FALSE);
                    menuInicio.setInstruction(Boolean.FALSE);
                    mostrar.Inicio();
                    scene.setRoot(mostrar.getget());
                    
                }
                if (menuInicio.getExit()) {
                    state = false;
                }
            }
            if (!jugar.getState()) {
                
                System.out.println("KKKKKKKKKKK");
                menuInicio.setState(Boolean.TRUE);
                scene.setRoot(menuInicio.getget());
                jugar=new Jugar();
            }
        }
    }

}

