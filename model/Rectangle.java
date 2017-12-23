package com.snake.model;

public class Rectangle
{
    private int X;
    private int Y;

    public int getX()
    {
        return X;
    }

    public void setX(int x)
    {
        X = x;
    }

    public int getY()
    {
        return Y;
    }

    public void setY(int y)
    {
        Y = y;
    }

    public Rectangle()
    {
        X = 0;
        Y = 0;
    }

    public Rectangle(int x, int y)
    {
        X = x;
        Y = y;
    }

    public boolean Equals(Rectangle r) {
        return r != null && (X == r.X) && (Y == r.Y);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Rectangle && this.Equals((Rectangle) o);
    }
}
