package Snake;

public class Rectangle
{
    public int X;
    public int Y;

    public Rectangle()
    {
        X = 0;
        Y = 0;
    }

    public  Rectangle(int x, int y)
    {
        X = x;
        Y = y;
    }

    public boolean Equals(Rectangle r)
    {
        if (r == null)
            return false;
        return (X == r.X) && (Y == r.Y);
    }
}


