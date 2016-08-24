/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Clase Notificacion clase hecha para hacer una notificacionn via twitter al
 * haber Game over ademas extiende de la clase thread para hacer alguna funcion
 * de manera paralela al ejecutar la aplicacion
 *
 * @author Erding Israel Flores Moreno
 * @author Jefferson Alexis Del Barco Pilozo
 */
public class Notificacion extends Thread {

    String tweet = "";
    Twitter twitter;

    /**
     * Constructor de la clase Notificacion
     *
     * inicializa todos los medios para hacer la coneccion de la cuenta del
     * twitter conn la aplicaccion
     */
    public Notificacion() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setOAuthConsumerKey("STFH7e9yQ8K7pIgs7oZSmsUB8");
        cb.setOAuthConsumerSecret("6Uj5BMITSyd17UNFxTLi47k39KkOMuwIszCgXkc8AC3mNJEp3U");
        cb.setOAuthAccessToken("133844036-u3qdbqgsxlSMeNWa5NzFrSCbnjAI7ExrRDHFrWw9");
        cb.setOAuthAccessTokenSecret("5m7rBhbEQmll0bGtPGC3sqE3mo3emjmrjKrCBg26t9jhG");

        twitter = new TwitterFactory(cb.build()).getInstance();
    }

    /**
     * metodo run de la clase Thread
     *
     * este metodo actualiza el estado de twuitter con un mensaje de
     * notificacion al jugador con el puntaje maximo que hizo en la partida
     */
    @Override
    public void run() {
        try {
            twitter.updateStatus(tweet);
        } catch (Exception ex) {
            System.out.println("Error");

        }

    }

    public Boolean confirmacionTwitter(Jugador jugador) {

        try {
            twitter.updateStatus(tweet);
        } catch (Exception ex) {
            System.out.println("Error");
            return false;
        }
        return true;
    }

    public void actualizarMensaje(Jugador jugador) {
        if (!jugador.getIdTwitter().contains("@")) {
            tweet = "@" + jugador.getIdTwitter() + " usted ha hecho la maximapuntuacion de " + jugador.getPuntaje();

        } else {
            tweet = jugador.getIdTwitter() + " usted ha hecho la maximapuntuacion de " + jugador.getPuntaje();
        }
    }
}
