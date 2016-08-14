/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escenarios;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Flores
 */
public class PaneSave {
    Pane principal;
    private int puntaje;
    private String nombre;
    private String idTwitter;
    Label mensaje;
    VBox confirmarSave;
    VBox save;

    public PaneSave(int puntaje) {
        this.puntaje = puntaje;
        principal=new Pane();
        
    }
    
    
}
