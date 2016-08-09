/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Palabras;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.HBox;

/**
 *
 * @author Flores
 */
public class Palabra {

    HBox hBoxPalabra;
    List<Letra> letras;
    String palabra;
    boolean checkinput=true;

    public Palabra(String palabra) {
        this.palabra = palabra;
        letras = new ArrayList<>();
        this.llenarLetras();
        hBoxPalabra = new HBox();
        llenarHbox();
    }

    public void llenarLetras() {
        String[] letrasCargadas = this.palabra.split("");
        System.out.println(letrasCargadas);
        for (String letra : letrasCargadas) {
            Letra letraTemp = new Letra(letra);
            letras.add(letraTemp);
        }
    }

    public void llenarHbox() {

        for (Letra letra : this.letras) {
            this.hBoxPalabra.getChildren().add(letra.getLabel());
        }
        System.out.println(this.palabra);
    }

    public HBox getPane() {
        return this.hBoxPalabra;
    }

    public Boolean checkPalabra() {
        int cont = 0;
        for (Letra letras : this.letras) {
            if (letras.getState()) {
                cont++;
            }
        }
        if (cont == this.letras.size()) {
            return true;
        } else {
            return false;
        }

    }
    

    public boolean isCheckinput() {
        return checkinput;
    }

    public void setCheckinput(boolean checkinput) {
        this.checkinput = checkinput;
    }

  
    public void input(String letra) {
        
        for (Letra letras : this.letras) {
            if (!letras.getState()) {
                if (letras.getletra().equals(letra)) {
                    letras.setState(true);
                    break;
                }
                else {
                    System.out.println("mal ingreso");
                    this.setCheckinput(false);
                    break;
                }
            }
        }
    }

}
