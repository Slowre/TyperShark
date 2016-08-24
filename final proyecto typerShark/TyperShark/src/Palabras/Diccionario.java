/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Palabras;

import Constantes.Settings;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase Diccionario psee todas las palabras para los animales
 *
 * @author Erding Israel Flores Moreno
 * @author Jefferson Alexis Del Barco Pilozo
 */
public class Diccionario {
    
    ArrayList<String> palabras = new ArrayList();
    /**
     * Constructor de la clase Diccionario
     *
     * usa el metodo llenarpalbras
     */
    public Diccionario() {
        llenarPalabras();
    }
     /**
      * metodo lleanrPalabras
     * lee el txt de las palabras y llena la lista
     */
    public void llenarPalabras() {
        Scanner Archi = null;
        try {
            Archi = new Scanner(new FileReader(Settings.direccionDiccionario));
            
            while (Archi.hasNext()) {
                String palabra = Archi.nextLine();
                this.palabras.add(palabra);
            }
        } catch (Exception e) {
            System.out.println("Error abriendo el Archivo ");
        } finally {
            Archi.close();
        }
    }
    /**
     * Metodo getPalabra
     *
     * @param kind verifica si es una pirañan o un tiburon
     * @return la palabra deseada si es piraña o tiburon
     */
    public String getPalabra(Boolean kind) {
        Random rnd = new Random();
        while (true) {
            try {
                Thread.sleep(50);
            } catch (Exception e) {
            }
            int select = rnd.nextInt(this.palabras.size());
            if (kind) {
                if (this.palabras.get(select).length() == 1) {
                    return this.palabras.get(select);
                }
            } else if (this.palabras.get(select).length() > 1) {
                return this.palabras.get(select);
            }
            
        }
    }
}
