package Snake;


public class Tools
{
    public static int Height;
    public static int Width;
    public static Direction Direction;

    public static int TravelingSpeed;

    public static int TotalScore;
    public static int ScoreForFood;
    public static boolean IsGameOver;

    public Tools()
    {
        Width = 15;
        Height = 15;
        Direction = Direction.Up;

        TravelingSpeed = 15;

        TotalScore = 0;
        ScoreForFood = 1;
        IsGameOver = false;
    }
}

