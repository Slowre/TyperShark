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
 *
 * @author Flores
 */
public abstract class SpriteBase {
    Image imagen;
    ImageView imageView;

    Pane layer;

    double x;
    double y;
    double vidas;
    double speed;
    double width;
    double height;

    boolean canMove = true;
    boolean remove = false;

    public SpriteBase(Image imagen, Pane layer, double x, double y, double vidas, double speed) {
        this.imagen = imagen;
        this.imageView = new ImageView(imagen);
        this.layer = layer;
        this.x = x;
        this.y = y;
       // this.imageView.relocate(x, y);
        this.vidas = vidas;
        this.speed = speed;
        this.width = imagen.getWidth();
        this.height = imagen.getHeight();

        
    }

    public void addLayer() {
        this.layer.getChildren().add(this.imageView);
    }

    public void removeBicho() {
        this.layer.getChildren().remove(this.imageView);
    }

    public Pane getPane() {
        return this.layer;
    }

    public void setPane(Pane pane) {
        this.layer = pane;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public double getX() {
        return x;
    }

    public void setX() {
        x += speed;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getVidas() {
        return vidas;
    }

    public void setVidas(double vidas) {
        this.vidas = vidas;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isCanMove() {
        return canMove;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public boolean isRemove() {
        return remove;
    }

    public void setRemove(boolean remove) {
        this.remove = remove;
    }
    
    public void move(){
        imageView.relocate(x, y);
    }
    public abstract void alive();
}
