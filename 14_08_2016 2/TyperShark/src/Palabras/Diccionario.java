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
 *
 * @author Flores
 */
public class Diccionario {
    
    ArrayList<String> palabras = new ArrayList();
    
    public Diccionario() {
        llenarPalabras();
    }
    
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
