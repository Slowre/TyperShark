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
 * Clase TiburonNegro es hijo de un animal
 *
 * @author Erding Israel Flores Moreno
 * @author Jefferson Alexis Del Barco Pilozo
 */
public class TiburonNegro extends Animal {

    private int points = Settings.SHARK_BLACK_POINTS;

    /**
     * Constructor de la clase Buceador
     *
     * inicializa un panel
     *
     * @param imagen
     * @param layer
     * @param x
     * @param y
     * @param vidas
     * @param speed
     * @param palabra
     */
    public TiburonNegro(Image imagen, Pane layer, double x, double y, int vidas, double speed, ArrayList<String> palabra) {
        super(imagen, layer, x, y, vidas, speed, palabra);
        this.imageView.setFitHeight(this.getHeight() * 0.25);
        this.imageView.setFitWidth(this.getWidth() * 0.25);
        this.palabra.getPane().relocate(x + (this.getHeight() * 0.25 / 4), y + (this.getWidth() * 0.25 / 5));
    }

    /**
     * metodo getpuntos
     *
     * @return la cantidad de puntos que tendra el animal
     */
    @Override
    public int getpuntos() {
        return this.points;
    }
}
