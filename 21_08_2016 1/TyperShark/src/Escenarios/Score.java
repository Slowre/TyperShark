/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escenarios;

import Constantes.Settings;
import Recursos.Jugador;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Flores
 */
public class Score {

    Image fondo;
    ImageView imageViewFondo;
    private BorderPane _root;
    StackPane rootPane = new StackPane();
    ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    VBox nombresVBox;
    VBox puntajesVBox;
    TextField txtnombre;
    Boolean state = true;
    HBox hh = new HBox();

    public Score() {
        _root = new BorderPane();
        nombresVBox = new VBox();
        puntajesVBox = new VBox();
        fondo = new Image("file:Oceanos.png");
        imageViewFondo = new ImageView(fondo);
        imageViewFondo.setFitHeight(Settings.SCENE_HEIGHT);
        imageViewFondo.setFitWidth(Settings.SCENE_WIDTH);
        rootPane.getChildren().addAll(imageViewFondo, _root);

        Label label1 = new Label("Nombre: ");
        label1.setTextFill(Color.WHITE);
        txtnombre = new TextField();
        txtnombre.setMinWidth(200);
        txtnombre.setMaxWidth(200);
        txtnombre.setPromptText("Ingrese su nombre");

        HBox nombreHBox = new HBox();
        nombreHBox.setSpacing(40);
        nombreHBox.setAlignment(Pos.CENTER);
        nombreHBox.getChildren().addAll(label1, txtnombre);

        Button search = new Button("Search");
        search.setOnAction(e -> {
            if (this.txtnombre.textProperty().get().equals("")) {
                this.actualizar();
                Collections.sort(jugadores);
                poner();
            }

        });

        Button regresar = new Button("Return");
        regresar.setOnAction(e -> {
            this.hh.getChildren().clear();
            this.state = false;

        });
        VBox botonesScore = new VBox();
        botonesScore.setAlignment(Pos.CENTER);
        botonesScore.getChildren().addAll(nombreHBox, search, regresar);
        botonesScore.setSpacing(50);
        _root.setLeft(botonesScore);

    }

    public StackPane getget() {
        return this.rootPane;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public void poner() {

        for (Jugador ju : this.jugadores) {
            Label mensaje1 = new Label();
            mensaje1.setFont(Font.font(null, FontWeight.BOLD, 30));
            mensaje1.setTextFill(Color.WHITE);
            mensaje1.setText(ju.getNombre());
            this.nombresVBox.getChildren().add(mensaje1);
            Label mensaje2 = new Label();
            mensaje2.setFont(Font.font(null, FontWeight.BOLD, 30));
            mensaje2.setTextFill(Color.WHITE);
            mensaje2.setText(String.valueOf(ju.getPuntaje()));
            this.puntajesVBox.getChildren().add(mensaje2);

        }
        if (!this.jugadores.isEmpty()) {

            hh.setAlignment(Pos.CENTER);
            hh.getChildren().addAll(this.nombresVBox, this.puntajesVBox);
            hh.setSpacing(10);
            this._root.setRight(hh);

        }

    }

    public void actualizar() {
        String cod = new String("\\|");
        Scanner Archi = null;
        try {
            Archi = new Scanner(new FileReader("Score.txt"));
            while (Archi.hasNext()) {
                String palabra = Archi.nextLine();
                String Cargado[] = palabra.split(cod);

                Jugador jugador = new Jugador(Cargado[0], Cargado[1], Integer.parseInt(Cargado[2]));
                jugadores.add(jugador);

            }
        } catch (Exception e) {
            System.out.println("Error abriendo el Archivo ");

        } finally {

            Archi.close();

        }
    }

    public void imprimir() {
        for (Jugador ju : this.jugadores) {
            System.out.println(ju.getNombre() + " " + ju.getPuntaje());
        }
    }
}
