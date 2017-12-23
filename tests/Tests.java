package com.snake.tests;
import com.snake.Consequences;
import com.snake.Game;
import com.snake.model.Direction;
import com.snake.model.Rectangle;
import com.snake.model.Snake;
import com.snake.model.Tools;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Tests {
    private Game game;
    private Snake snake;
    private Consequences consequences;

    @BeforeMethod
    public void Initialization() {
        game = new Game();
        game.startNewGame();
        snake = game.getMySnake();
        snake = game.getMySnake();
        consequences = game.getCons();
    }

    @Test
    void MoveHeadOfSnake()
    {
        game.moveSnake();

        Assert.assertEquals(snake.getBody().size(), 0);
        Assert.assertEquals(snake.getSnakeHead().getX(), 15);
        Assert.assertEquals(snake.getSnakeHead().getY(), 14);
    }

    @Test
    void MoveSnakeWithTwoParts()
    {
        consequences.eat();
        game.moveSnake();

        Assert.assertEquals(game.getMySnake().getBody().size(), 1);
        Assert.assertEquals(game.getMySnake().getSnakeHead().getX(), 15);
        Assert.assertEquals(game.getMySnake().getSnakeHead().getY(), 14);

        Assert.assertEquals(game.getMySnake().getBody().get(0).getX(), 15);
        Assert.assertEquals(game.getMySnake().getBody().get(0).getY(), 15);
    }

    @Test
    void MoveWithChangeDirection()
    {
        Tools tools = new Tools();
        tools.setDirection(Direction.Left);
        game.setTools(tools);
        game.moveSnake();

        Assert.assertEquals(snake.getBody().size(), 0);
        Assert.assertEquals(snake.getSnakeHead().getX(), 14);
        Assert.assertEquals(snake.getSnakeHead().getY(), 15);
    }
    @Test
    void WhenSnakeDieGameWillOver()
    {
        game.getFood().setDiedFood(new Rectangle(15, 14));
        game.moveSnake();

        Assert.assertEquals(game.getTools().getIsGameOver(), true);
    }

    @Test
    void MoveLongSnake()
    {
        Snake snake = game.getMySnake();
        for (int i = 0; i < 5; i++)
            consequences.eat();
        game.moveSnake();

        Assert.assertEquals(snake.getBody().size(), 5);
        Assert.assertEquals(snake.getSnakeHead().getX(), 15);
        Assert.assertEquals(snake.getSnakeHead().getY(), 14);
    }

    @Test
    void DieWhenTouchWall()
    {
        game.moveSnake();

        Assert.assertEquals(consequences.isSnakeDie(), false);

        for (int i = 0; i < 30; i++)
            game.moveSnake();

        Assert.assertEquals(consequences.isSnakeDie(), true);
    }

    @Test
    void DieWhenEatHimself()
    {
        for (int i = 0; i < 5; i++)
            consequences.eat();
        game.moveSnake();

        Tools tool = new Tools();
        tool.setDirection(Direction.Left);
        game.setTools(tool);
        game.moveSnake();

        tool.setDirection(Direction.Down);
        game.setTools(tool);
        game.moveSnake();

        tool.setDirection(Direction.Right);
        game.setTools(tool);
        game.moveSnake();

        Assert.assertEquals(consequences.isSnakeDie(), true);
    }

    @Test
    void DieSnakeEatDiedFood()
    {
        game.moveSnake();
        game.getFood().setDiedFood(new Rectangle(15, 14));

        Assert.assertEquals(consequences.isSnakeDie(), true);
    }

    @Test
    void whenSnakeEatsFoodLengthIncreases()
    {
        game.moveSnake();
        consequences.eat();

        Assert.assertEquals(snake.getBody().size(), 1);
    }

    @Test
    void whenSnakeEatsAlcoholicFoodLengthIncreases()
    {
        game.getFood().setAlcoholicFood(new Rectangle(15, 14));
        game.moveSnake();

        Assert.assertEquals(snake.getBody().size(), 1);
    }

    @Test
    void WantEat()
    {
        game.moveSnake();
        game.getFood().setNotAlcoholicFood(new Rectangle(15, 14));

        Assert.assertEquals(consequences.isSnakeEat(), true);
    }

    @Test
    void WantEatAlcoholicFood()
    {
        game.moveSnake();
        game.getFood().setAlcoholicFood(new Rectangle(15, 14));

        Assert.assertEquals(consequences.isSnakeAlcohol(), true);
    }

    @Test
    void SnakeEatAlcoholicFoodAndDirectionChange()
    {
        game.moveSnake();
        game.getFood().setAlcoholicFood(new Rectangle(15, 14));
        game.moveSnake();

        Assert.assertEquals(snake.getBody().size(), 0);
        Assert.assertEquals(snake.getSnakeHead().getX(), 15);
        Assert.assertEquals(snake.getSnakeHead().getY(), 13);
    }
}