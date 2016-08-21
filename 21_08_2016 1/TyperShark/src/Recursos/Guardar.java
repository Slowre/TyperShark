/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Flores
 */
public class Guardar {

    public Guardar() {
    }
    

    public void save(Jugador jugador) {

        String linea = jugador.getNombre() + "|" + jugador.getIdTwitter() + "|" + jugador.getPuntaje();
        try {
            File a = new File("Score.txt");
            FileWriter salida = new FileWriter(a, true);
            salida.write(linea);
            salida.write("\r\n");
            salida.close();

        } catch (Exception e) {
            System.out.println("Error tipo" + e);
        } finally {
        }

    }
}
