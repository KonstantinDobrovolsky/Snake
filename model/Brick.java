package com.snake.model;

import javax.swing.*;
import java.awt.*;

public class Brick extends Rectangle {
    public Image picBrick;

    public Brick(int x, int y) {
        this.setX(x);
        this.setY(y);

        loadImages();
    }

    private void loadImages(){
        ImageIcon na = new ImageIcon("pic\\brick.png");
        picBrick = na.getImage();
    }
}
