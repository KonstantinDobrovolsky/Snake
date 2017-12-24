package com.snake;
import com.snake.model.*;

import java.util.HashMap;
import java.util.Map;

public class Consequences {
    private Snake snake;
    private Food food;
    private Tools tools;
    private Level currentLevel;
    private Game game;

    Consequences(Snake snake, Food food, Tools tools, Level level, Game game)
    {
        this.snake = snake;
        this.food = food;
        this.tools = tools;
        this.currentLevel = level;
        this.game = game;
    }

    public void recountConsequences()
    {
        Map<Direction, Tuple> dict = new HashMap<>();
        updateDictForDirection(dict);

        for (int i = snake.getBody().size() - 1; i >= 0; i--)
        {
            if (i == 0)
            {
                snake.setBodyPart(i,
                        snake.getSnakeHead().getX(),
                        snake.getSnakeHead().getY());
            }
            else
            {
                snake.setBodyPart(i,
                        snake.getBody().get(i - 1).getX(),
                        snake.getBody().get(i - 1).getY());
            }
        }

        snake.setSnakeHead(
                snake.getSnakeHead().getX() + dict.get(tools.getDirection()).getItem1(),
                snake.getSnakeHead().getY() + dict.get(tools.getDirection()).getItem2());

        performJump();

        if (isSnakeDie())
            snakeShouldDie(tools);

        if (isSnakeEat()) {
            eat();
            food.generateNotAlcoholicFood();
            tools.setTotalScore(tools.getTotalScore() + Tools.getScoreForFood());
        }

        if (isSnakeAlcohol())
        {
            eat();
            food.generateAlcoholicFood();
            tools.setTotalScore(tools.getTotalScore() + 2 * Tools.getScoreForFood());
            snake.setAlcohol(snake.getAlcohol() * -1);
        }

    }

    public void updateDictForDirection
            (Map<Direction, Tuple> dict)
    {
        dict.put(Direction.Right, new Tuple(1, 0));
        dict.put(Direction.Left, new Tuple(-1, 0));
        dict.put(Direction.Up, new Tuple(0, -1));
        dict.put(Direction.Down, new Tuple(0, 1));
    }

    public boolean isSnakeDie()
    {
        int maxX = Tools.getMaxX();
        int maxY = Tools.getMaxY();


        if (snake.getSnakeHead().getX() < 0 || snake.getSnakeHead().getY() < 0
                || snake.getSnakeHead().getX() >= maxX || snake.getSnakeHead().getY() >= maxY)
        {
            return true;
        }

        for (int j = 1; j < snake.getBody().size(); j++)
        {
            if (snake.getSnakeHead().getX() == snake.getBody().get(j).getX() &&
                    snake.getSnakeHead().getY() == snake.getBody().get(j).getY())
            {
                return true;
            }
        }

        if (snake.getSnakeHead().getX() == food.getDiedFood().getX() &&
                snake.getSnakeHead().getY() == food.getDiedFood().getY())
            return true;

        return currentLevel.isInBricks(snake.getSnakeHead());

    }

    public boolean isSnakeEat()
    {
        return (snake.getSnakeHead().getX() == food.getNotAlcoholicFood().getX()
                && snake.getSnakeHead().getY() == food.getNotAlcoholicFood().getY());
    }

    public void performJump() {
        Bridge bridge = currentLevel.getBridge(0);
        if (snake.getSnakeHead().getX() == bridge.getX() &
                snake.getSnakeHead().getY() == bridge.getY()){
            if (currentLevel == bridge.top){
                if (bridge.top != null)
                    currentLevel = bridge.bottom;
                    game.setLevel(bridge.bottom);
            }
            else {
                if (bridge.bottom != null)
                    currentLevel = bridge.top;
                    game.setLevel(bridge.top);
            }
            food.generateAllFood();
        }
//        int bridgeIndex = currentLevel.indexInBridges(snake.getSnakeHead());
//        if (bridgeIndex != -1) {
//            Level newLevel = currentLevel.getBridge(bridgeIndex).Map(currentLevel);
//            currentLevel = newLevel != null ? newLevel : currentLevel;
//        }


    }

    public void eat()
    {
        Rectangle partOfSnake;
        if (snake.getBody().size() != 0) {
            partOfSnake = new Rectangle(
                    snake.getBody().get(snake.getBody().size() - 1).getX(),
                    snake.getBody().get(snake.getBody().size() - 1).getY()
            );
        }
        else {
            partOfSnake = new Rectangle(
                    snake.getSnakeHead().getX(),
                    snake.getSnakeHead().getY()
            );
        }

        snake.getBody().add(partOfSnake);
    }

    public boolean isSnakeAlcohol()
    {
        return snake.getSnakeHead().getX() == food.getAlcoholicFood().getX()
                && snake.getSnakeHead().getY() == food.getAlcoholicFood().getY();
    }

    public void snakeShouldDie(Tools tools)
    {
        tools.setIsGameOver(true);
        snake.setAlcohol(1);
    }
}
