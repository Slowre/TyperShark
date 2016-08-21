/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escenarios;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author Flores
 */
public class MostrarInstruction {

    Boolean state = true;
    private GridPane _root;
    StackPane rootPane = new StackPane();
    Text stage = new Text();

    public MostrarInstruction() {
        _root = new GridPane();

    }

    public void Inicio() {
        Label titulo1 = new Label("Escenario 1");
        Label subt1 = new Label("El juego consiste en escribir las palabras o\nletras que "
                + "salen en pantalla por medio de \nanimales marino, estos"
                + "pueden ser: tiburo-\nnes, pirañas y tiburones negros.\n");
        Label subt11 = new Label("Si el jugador se equivoca en escribir la palabra o letra"
                + "que se muestra\npor pantalla entonces el animal marino"
                + "que corresponde a dicha pala-\nbra o letra se moverá más"
                + "rápido para devorarlo y así tomar sus vidas.\n");
        titulo1.setFont(Font.font(null, FontWeight.BOLD, 40));
        titulo1.setTextFill(Color.RED);
        subt1.setFont(Font.font(null, FontWeight.BOLD, 18));
        subt1.setTextFill(Color.BLACK);
        subt11.setFont(Font.font(null, FontWeight.BOLD, 18));
        subt11.setTextFill(Color.BLACK);
        Image img1 = new Image("file:instr1.png");
        ImageView imgV1 = new ImageView();
        imgV1.setImage(img1);
        imgV1.setFitHeight(img1.getHeight() * 0.3);
        imgV1.setFitWidth(img1.getWidth() * 0.3);
        Button next1 = new Button("Next");
        Button back1 = new Button("Inicio");
        _root.add(back1, 1, 12, 2, 2);
        _root.setPadding(new Insets(50));
        _root.add(next1, 6, 12, 2, 2);
        _root.add(imgV1, 0, 1);
        _root.add(subt1, 2, 1, 8, 4);
        _root.add(subt11, 0, 5, 10, 4);
        _root.add(titulo1, 1, 0, 4, 1);

        rootPane.getChildren().addAll(this.getRoot());
        next1.setOnAction((ActionEvent e) -> {
            rootPane.getChildren().clear();
            _root.getChildren().removeAll(next1, imgV1, subt1, subt11, titulo1, back1);
            Label titulo2 = new Label("Escenario 2");
            Label subt2 = new Label("Si el tiburón o tiburón negro llega hasta don-\n"
                    + "de se encuentra el buso entonces este perde-\n"
                    + "ra automáticamente una vida, y podría per-\nder el juego.");
            Label subt21 = new Label("En el caso de las pirañas es totalmente diferente, para que el buso "
                    + "pierda\nuna vida tendría que llegar tres pirañas hasta donde se en"
                    + "cuentra el bu-\nso, no es necesario que lleguen las tres al mismo tiem"
                    + "po.");
            titulo2.setFont(Font.font(null, FontWeight.BOLD, 40));
            titulo2.setTextFill(Color.RED);
            subt2.setFont(Font.font(null, FontWeight.BOLD, 18));
            subt2.setTextFill(Color.BLACK);
            subt21.setFont(Font.font(null, FontWeight.BOLD, 18));
            subt21.setTextFill(Color.BLACK);
            Image img2 = new Image("file:instr2.png");
            ImageView imgV2 = new ImageView();
            imgV2.setImage(img2);
            imgV2.setFitHeight(img2.getHeight() * 0.3);
            imgV2.setFitWidth(img2.getWidth() * 0.3);
            Button next2 = new Button("Next");
            Button back2 = new Button("Back");
            _root.setPadding(new Insets(50));
            _root.add(next2, 6, 12, 2, 2);
            _root.add(back2, 1, 12, 2, 2);
            _root.add(imgV2, 0, 1);
            _root.add(subt2, 2, 1, 8, 4);
            _root.add(subt21, 0, 5, 10, 4);
            _root.add(titulo2, 1, 0, 4, 1);

            rootPane.getChildren().addAll(this.getRoot());
            back2.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    rootPane.getChildren().clear();
                    _root.getChildren().removeAll(next2, imgV2, subt2, subt21, titulo2, back2);
                    _root.getChildren().addAll(next1, imgV1, subt1, subt11, titulo1, back1);
                    rootPane.getChildren().addAll(_root);
                }
            });
            next2.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    rootPane.getChildren().clear();
                    _root.getChildren().removeAll(next2, imgV2, subt2, subt21, titulo2, back2);
                    Label titulo3 = new Label("Escenario 3");
                    Label subt3 = new Label("Hay un comodin el cual permite elimi-\nnar todos "
                            + "los animales marinos, se lo\n"
                            + "puede utilizar cuando este cargado\n100% y se "
                            + "verifica en el lado inferior\nizquierdo de la pantalla");
                    Label subt31 = new Label("Al usar el comodin el score aumenta por los animales marinos elimi-\n"
                            + "nados, pero para usarlo nuevamente hay que esperar que cargue."
                            + "po.");
                    titulo3.setFont(Font.font(null, FontWeight.BOLD, 40));
                    titulo3.setTextFill(Color.RED);
                    subt3.setFont(Font.font(null, FontWeight.BOLD, 18));
                    subt3.setTextFill(Color.BLACK);
                    subt31.setFont(Font.font(null, FontWeight.BOLD, 18));
                    subt31.setTextFill(Color.BLACK);
                    Image img3 = new Image("file:instr3.png");
                    ImageView imgV3 = new ImageView();
                    imgV3.setImage(img3);
                    imgV3.setFitHeight(img3.getHeight() * 0.3);
                    imgV3.setFitWidth(img3.getWidth() * 0.3);
                    Button back3 = new Button("Back");
                    _root.setPadding(new Insets(50));
                    _root.add(back3, 1, 12, 2, 2);
                    _root.add(imgV3, 0, 1);
                    _root.add(subt3, 2, 1, 8, 4);
                    _root.add(subt31, 0, 5, 10, 4);
                    _root.add(titulo3, 1, 0, 4, 1);
                    rootPane.getChildren().addAll(_root);
                    back3.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                            rootPane.getChildren().clear();
                            _root.getChildren().removeAll(imgV3, subt3, subt31, titulo3, back3);
                            _root.getChildren().addAll(next2, imgV2, subt2, subt21, titulo2, back2);
                            rootPane.getChildren().addAll(_root);
                        }
                    });
                }
            });
        });
        back1.setOnAction(e -> {
            rootPane.getChildren().clear();
            _root.getChildren().clear();
            this.state=false;

        });
    }

    public StackPane getget() {
        return this.rootPane;
    }

    public GridPane getRoot() {
        return _root;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

}
