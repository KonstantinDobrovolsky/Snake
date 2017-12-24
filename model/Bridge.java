package com.snake.model;

import com.sun.istack.internal.Nullable;

import javax.swing.*;
import java.awt.*;

public class Bridge extends Rectangle {
    public Image picBridge;
    public Level top, bottom;

    public Bridge(Level top, Level bottom)
    {
        this.setX(0);
        this.setY(0);

        this.top = top;
        this.bottom = bottom;

        loadImages();
    }

    public Bridge(int x, int y, Level top, Level bottom)
    {
        this.setX(x);
        this.setY(y);

        this.top = top;
        this.bottom = bottom;

        loadImages();
    }

    @Nullable
    public Level Map(Level current) {
        if (current == top)
            return bottom;
        if (current == bottom)
            return top;
        return null;
    }

    private void loadImages(){
        ImageIcon na = new ImageIcon("pic\\bridge.png");
        picBridge = na.getImage();
    }
}
