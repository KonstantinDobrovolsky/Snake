package com.snake.model;

import com.sun.istack.internal.Nullable;
import java.awt.*;

public class Bridge extends Rectangle {
    public static Image image;
    private Level top, bottom;

    public Bridge(Level top, Level bottom)
    {
        this.setX(0);
        this.setY(0);

        this.top = top;
        this.bottom = bottom;
    }

    public Bridge(int x, int y, Level top, Level bottom)
    {
        this.setX(x);
        this.setY(y);

        this.top = top;
        this.bottom = bottom;
    }

    @Nullable
    public Level Map(Level current) {
        if (current == top)
            return bottom;
        if (current == bottom)
            return top;
        return null;
    }
}
