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
 * Clase SceneOrganizer oraganiza las diferentes pantallas
 *
 * @author Erding Israel Flores Moreno
 * @author Jefferson Alexis Del Barco Pilozo
 */
public class SceneOrganizer {

    Scene scene;
    Mar jugar;
    MenuInicio menuInicio;
    PaneSave save;
    MostrarInstruction instrucciones;
    Score score;
    Boolean state = true;
    Timeline timeline;

    /**
     * Constructor de la clase SceneOrganizer
     *
     * inicializa todas las pantallas y pone como principal la de menu inicio
     */
    public SceneOrganizer() {
        jugar = new Mar();
        menuInicio = new MenuInicio();
        save = new PaneSave();
        instrucciones = new MostrarInstruction();
        score = new Score();
        menuInicio.setState(Boolean.TRUE);
        scene = new Scene(menuInicio.getget(), Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
        this.setupTimeline();

    }

    /**
     * metodo getScene
     *
     *
     * @return regresa el scene del stage
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * metodo getState
     *
     *
     * regresa el estado dela ventana
     */
    public Boolean getState() {
        return state;
    }

    /**
     * Metodo setupTimeline pone en marcha los diferentes Keyframe que se
     * encuentran dentro
     */
    public void setupTimeline() {
        KeyFrame kf = new KeyFrame(Duration.millis(100), new changWindow());
        timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    /**
     * Clase interna TimeHandler elige que ventana debe presentarse segun el
     * estado en que se encuentre
     */
    private class changWindow implements EventHandler<ActionEvent> {

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
                    menuInicio.setState(Boolean.FALSE);
                    menuInicio.setScore(Boolean.FALSE);
                    scene.setRoot(score.getget());

                }
                if (menuInicio.getInstruction()) {
                    menuInicio.setState(Boolean.FALSE);
                    menuInicio.setInstruction(Boolean.FALSE);
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
                save.musica();
                scene.setRoot(save.getPane());
            }
            if (!save.getState()) {
                save.setState(true);
                save.fin();
                menuInicio.setState(Boolean.TRUE);
                scene.setRoot(menuInicio.getget());
                jugar = new Mar();
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
