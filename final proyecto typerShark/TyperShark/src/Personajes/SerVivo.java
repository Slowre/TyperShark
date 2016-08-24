/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Clase SerVivo una clase padre cualquier ser vivo
 *
 * @author Erding Israel Flores Moreno
 * @author Jefferson Alexis Del Barco Pilozo
 */
public class SerVivo {

    Image imagen;
    ImageView imageView;

    Pane layer;

    double x;
    double y;
    int vidas;
    double speed;
    double width;
    double height;

    /**
     * Constructor de la clase  SerVivo
     *
     * inicializa un panel
     *
     * @param imagen imagen del animal
     * @param layer panel en que se colocara al animal
     * @param x ubicacion que se desea en x
     * @param y ubicacion que se desea en y
     * @param vidas cantidad de vidas
     * @param speed velocidad de movimiento
     */
    public SerVivo(Image imagen, Pane layer, double x, double y, int vidas, double speed) {
        this.imagen = imagen;
        this.imageView = new ImageView(imagen);
        this.layer = layer;
        this.x = x;
        this.y = y;
        this.vidas = vidas;
        this.speed = speed;
        this.width = imagen.getWidth();
        this.height = imagen.getHeight();

    }

    /**
     * metodo addLayer
     *
     * pone la imageview al panel que se le asigno
     */
    public void addLayer() {
        this.layer.getChildren().add(this.imageView);
    }

    /**
     * metodo removeBicho
     *
     * si el ser vivo tiene cero vidas se es removido del panel que se le asigno
     */
    public void removeBicho() {
        if (this.vidas == 0) {
            this.layer.getChildren().remove(this.imageView);
        }
    }

    /**
     * metodo setPane
     *
     *
     * @param pane asignar panel al ser vivo
     */
    public void setPane(Pane pane) {
        this.layer = pane;
    }

    /**
     * metodo getImagen
     *
     * obtener la imagen del ser vivo
     */
    public Image getImagen() {
        return imagen;
    }

    /**
     * metodo setImagen
     *
     *
     * @param imagen setear la imagen del ser vivo
     */
    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    /**
     * metodo getImageView
     *
     *
     * @return regresa el imagenview del ser vivo
     */
    public ImageView getImageView() {
        return imageView;
    }

    /**
     * metodo setImageView
     *
     *
     * @param imageView setea el imagenvieew del ser vivo
     */
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    /**
     * metodo getX
     *
     *
     * @return regresa la poiscion en x donde se encuentre el ser vivo
     */
    public double getX() {
        return x;
    }

    /**
     * metodo getY
     *
     *
     * @return regresa la poiscion en y donde se encuentre el ser vivo
     */
    public double getY() {
        return y;
    }

    /**
     * metodo getVidas
     *
     *
     * @return regresa las vidas que posee el ser vivo
     */
    public int getVidas() {
        return vidas;
    }

    /**
     * metodo setVidas
     *
     *
     * @param vidas setea las vidas del ser vivo
     */
    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    /**
     * metodo getSpeed
     *
     *
     * @return regresa la velocidad de movimiento del ser vivo
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * metodo setSpeed
     *
     *
     * @param speed setea la velocidad del ser vivo
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * metodo getWidth
     *
     *
     * @return regresa el ancho del ser vivo
     */
    public double getWidth() {
        return width;
    }

    /**
     * metodo setWidth
     *
     *
     * @param width setea el ancho del ser vivo
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * metodo getHeight
     *
     *
     * @return regresa el alto del ser vivo
     */
    public double getHeight() {
        return height;
    }

    /**
     * metodo setHeight
     *
     *
     * @param height setea el alto del ser vivo
     */
    public void setHeight(double height) {
        this.height = height;
    }

}
