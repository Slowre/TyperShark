/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Flores
 */
public class Notificacion {

   
    public Notificacion() {
    }

    public Boolean confirmacionTwitter(Jugador jugador) {
        String tweet = "";
        if (!jugador.getIdTwitter().contains("@")) {
            tweet = "@" + jugador.getIdTwitter() + " usted ha hecho la maximapuntuacion de " + jugador.getPuntaje();

        } else {
            tweet = jugador.getIdTwitter() + " usted ha hecho la maximapuntuacion de " + jugador.getPuntaje();
        }

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setOAuthConsumerKey("STFH7e9yQ8K7pIgs7oZSmsUB8");
        cb.setOAuthConsumerSecret("6Uj5BMITSyd17UNFxTLi47k39KkOMuwIszCgXkc8AC3mNJEp3U");
        cb.setOAuthAccessToken("133844036-u3qdbqgsxlSMeNWa5NzFrSCbnjAI7ExrRDHFrWw9");
        cb.setOAuthAccessTokenSecret("5m7rBhbEQmll0bGtPGC3sqE3mo3emjmrjKrCBg26t9jhG");

        Twitter twitter = new TwitterFactory(cb.build()).getInstance();
        try {
            twitter.updateStatus(tweet);
        } catch (Exception ex) {
            System.out.println("Error");
            return false;
        }
        return true;
    }
}
