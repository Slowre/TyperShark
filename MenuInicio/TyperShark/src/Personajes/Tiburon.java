/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Constantes.Settings;
import Palabras.Palabra;
import Personajes.Animal;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

/**
 *
 * @author Flores
 */
public class Tiburon extends Animal {
    private int points=Settings.SHARK_POINTS;
    public Tiburon(Image imagen, Pane layer, double x, double y, double vidas, double speed, String palabra) {
        super(imagen, layer, x, y, vidas, speed, palabra);
        this.imageView.setFitHeight(this.getHeight() * 0.25);
        this.imageView.setFitWidth(this.getWidth() * 0.25);
        //setupLabel(palabra);
        this.palabra.getPane().relocate(x + imageView.getLayoutX() * 0.25 / 2, y + 50);
    }
    

//    @Override
//    public void setupLabel(String cadena) {
//        palabra = new Palabra(cadena);
//        palabra.getPane().relocate(x + imageView.getLayoutX() * 0.25 / 2, y + 50);
//        //this.pane.getChildren().add(palabra.getPane());
//        this.layer.getChildren().add(palabra.getPane());
//    }

}
