/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import Constantes.Settings;
import Escenarios.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.util.Duration;

/**
 *
 * @author Flores
 */
public class SceneOrganizer {

    Scene scene;
    Jugar jugar;
    MenuInicio menuInicio;
    PaneSave save;
    MostrarInstruction instrucciones;
    Score score;
    Boolean state = true;
    Timeline timeline;

    public SceneOrganizer() {
        jugar = new Jugar();
        menuInicio = new MenuInicio();
        save = new PaneSave();
        instrucciones = new MostrarInstruction();
        score =new Score();
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
                    //jugar.setState(Boolean.TRUE);
                    jugar.Inicio();
                    scene.setRoot(jugar.getget());
                }
                if (menuInicio.getScore()) {
                     menuInicio.setState(Boolean.FALSE);
                    menuInicio.setScore(Boolean.FALSE);
                    //jugar.setState(Boolean.TRUE);
                   // instrucciones.Inicio();
                    scene.setRoot(score.getget());
                    
                    
                    
                }
                if (menuInicio.getInstruction()) {
                    menuInicio.setState(Boolean.FALSE);
                    menuInicio.setInstruction(Boolean.FALSE);
                    //jugar.setState(Boolean.TRUE);
                    instrucciones.Inicio();
                    scene.setRoot(instrucciones.getget());

                }
                if (menuInicio.getExit()) {
                    state = false;
                    System.exit(0);
                }
            }
            if (!jugar.getState()) {
                save.setPuntaje(jugar.getBuceador().getPuntaje());
                scene.setRoot(save.getPane());
                //menuInicio.setState(Boolean.TRUE);
                //scene.setRoot(menuInicio.getget());
                //System.out.println(jugar.getBuceador().getPuntaje());

                //jugar=new Jugar();
            }
            if (!save.getState()) {
                save.setState(true);
                menuInicio.setState(Boolean.TRUE);
                scene.setRoot(menuInicio.getget());
                jugar = new Jugar();
            }
            if (!instrucciones.getState()) {
                instrucciones.setState(true);
                menuInicio.setState(Boolean.TRUE);
                scene.setRoot(menuInicio.getget());
            }
            if (!score.getState()) {
                score.setState(true);
                menuInicio.setState(Boolean.TRUE);
                scene.setRoot(menuInicio.getget());
            }
        }
    }

}
