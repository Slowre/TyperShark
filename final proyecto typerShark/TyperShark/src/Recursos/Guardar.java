/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import java.io.File;
import java.io.FileWriter;

/**
 * Clase Guardar una clase hecvha para guardar las partidas
 *
 * @author Erding Israel Flores Moreno
 * @author Jefferson Alexis Del Barco Pilozo
 */
public class Guardar {

    /**
     * Constructor de la clase Guardar por default
     *
     *
     */
    public Guardar() {

    }

    /**
     * metodo save
     *
     * recibe un jugador y su nombre, id twtitter y puntuacion son escritos en
     * un txt de scores
     */
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
