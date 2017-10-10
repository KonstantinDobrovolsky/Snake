package Snake;
import javax.tools.Tool;
import java.util.*;

public class Game
{
    public List<Rectangle> MySnake = new ArrayList<>();
    public Rectangle NotAlcoholicFood = new Rectangle();
    public Rectangle AlcoholicFood = new Rectangle();
    public Rectangle DiedFood = new Rectangle();
    public int Width = 605;
    public int Height = 478;
    Random random = new Random();
    int alcohol = 1;

    public Rectangle GenerateFood()
    {
        Rectangle food = new Rectangle();
        food.X = random.nextInt(
                Width / Tools.Width);
        food.Y = random.nextInt(
                Height / Tools.Height);
        return food;
    }

    public void GenerateAllFood()
    {
        NotAlcoholicFood = GenerateFood();
        AlcoholicFood = GenerateFood();
        while (AlcoholicFood.Equals(NotAlcoholicFood))
        {
            AlcoholicFood = GenerateFood();
        }
        DiedFood = GenerateFood();
        while (DiedFood.Equals(NotAlcoholicFood)
                || DiedFood.Equals(AlcoholicFood))
        {
            DiedFood = GenerateFood();
        }
    }

    public void UpdateDictForDirection
            (Map<Direction, Tuple> dict)
    {
        dict.put(Direction.Right, new Tuple(1 * alcohol, 0));
        dict.put(Direction.Left, new Tuple(-1 * alcohol, 0));
        dict.put(Direction.Up, new Tuple(0, -1 * alcohol));
        dict.put(Direction.Down, new Tuple(0, 1 * alcohol));
    }

    public boolean IsSnakeDie()
    {
        int maxX = Width / Tools.Width;
        int maxY = Height / Tools.Height;


        if (MySnake.get(0).X < 0 || MySnake.get(0).Y < 0
                || MySnake.get(0).X >= maxX || MySnake.get(0).Y >= maxY)
        {
            return true;
        }

        for (int j = 1; j < MySnake.size(); j++)
        {
            if (MySnake.get(0).X == MySnake.get(j).X &&
                    MySnake.get(0).Y == MySnake.get(j).Y)
            {
                return true;
            }
        }

        if (MySnake.get(0).X == DiedFood.X && MySnake.get(0).Y == DiedFood.Y)
            return true;

        return false;
    }

    public boolean IsSnakeEat()
    {
        return MySnake.get(0).X == NotAlcoholicFood.X
                && MySnake.get(0).Y == NotAlcoholicFood.Y;
    }

    public boolean IsSnakeAlcohol()
    {
        return MySnake.get(0).X == AlcoholicFood.X
                && MySnake.get(0).Y == AlcoholicFood.Y;
    }

    public void MovePlayer()
    {
        Map<Direction, Tuple> dict = new HashMap<>();
        UpdateDictForDirection(dict);

        for (int i = MySnake.size() - 1; i >= 1; i--)
        {
            MySnake.get(i).X = MySnake.get(i - 1).X;
            MySnake.get(i).Y = MySnake.get(i - 1).Y;
        }

        MySnake.get(0).X += dict.get(Tools.Direction).Item1;
        MySnake.get(0).Y += dict.get(Tools.Direction).Item2;

        if (IsSnakeDie())
            SnakeShouldDie();

        if (IsSnakeAlcohol())
        {
            Eat();
            alcohol *= -1;
        }

        if (IsSnakeEat())
            Eat();
    }

    public void Eat()
    {
        Rectangle partOfSnake = new Rectangle (
                MySnake.get(MySnake.size() - 1).X,
                MySnake.get(MySnake.size() - 1).Y
        );

        MySnake.add(partOfSnake);

        Tools.TotalScore += Tools.ScoreForFood;
        GenerateAllFood();
    }

    public void SnakeShouldDie()
    {
        Tools.IsGameOver = true;
        alcohol = 1;
    }
}

