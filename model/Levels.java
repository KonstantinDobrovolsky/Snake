package com.snake.model;

import java.util.ArrayList;

public class Levels {


    public Level getFirstLevel(){
        ArrayList<Brick> bricks = new ArrayList<>();
        bricks.add(new Brick(5, 2));
        bricks.add(new Brick(5, 4));
        bricks.add(new Brick(5, 6));
        bricks.add(new Brick(7, 6));


        bricks.add(new Brick(8, 20));
        bricks.add(new Brick(10, 20));
        bricks.add(new Brick(10, 18));
        bricks.add(new Brick(12, 18));
        Level lvl = new Level(new ArrayList<Bridge>(), bricks);

        return lvl;
    }
}
