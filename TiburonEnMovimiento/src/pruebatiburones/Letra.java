/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebatiburones;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

/**
 *
 * @author Flores
 */
public class Letra {

    private String letra;
    Label label;
    Boolean state = false;

    public Letra(String letra) {
        this.letra = letra;
        label = new Label(letra);
        label.setFont(Font.font(null, FontWeight.BOLD, 25));
        label.setTextFill(Color.RED);
        setupTimeline();
    }

    public String getletra() {
        return this.letra;
    }

    public Label getLabel() {
        return this.label;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Boolean getState() {
        return this.state;
    }

    public void ChangeColor() {
        this.label.setTextFill(Color.YELLOW);
    }

    public void setupTimeline() {
        KeyFrame kf = new KeyFrame(Duration.millis(100), new TimeHandler());
        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private class TimeHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if(state){
            ChangeColor();
            }
            
        }

    }
}
