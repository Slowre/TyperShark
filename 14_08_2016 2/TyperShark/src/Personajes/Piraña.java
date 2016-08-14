/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Constantes.Settings;
import Palabras.Palabra;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

/**
 *
 * @author Flores
 */
public class Piraña extends Animal {

    private int points = Settings.PIRANHAS_POINTS;

    public Piraña(Image imagen, Pane layer, double x, double y, double vidas, double speed, ArrayList<String> palabra) {
        super(imagen, layer, x, y, vidas, speed, palabra);
        this.imageView.setFitHeight(this.getHeight() * 0.25);
        this.imageView.setFitWidth(this.getWidth() * 0.25);
        this.palabra.getPane().relocate(x + 10, y + 20);
    }

//    public int getPoints() {
//        return points;
//    }

    @Override
    public int getpuntos() {
        return this.points;
    }

}
