package com.snake.model;

import com.snake.Tuple;

import java.util.ArrayList;

public class Levels {
    
    private Level levelFactory(ArrayList<Tuple> bridges_coorditanes,
                               ArrayList<Tuple> bricks_coordinates,
                               Level top,
                               Level bottom){
        ArrayList<Brick> bricks = new ArrayList<>();
        for (Tuple tuple: bricks_coordinates)
            bricks.add(new Brick(tuple.getItem1(), tuple.getItem2()));

        ArrayList<Bridge> bridges = new ArrayList<>();
        for (Tuple tuple: bridges_coorditanes)
            bridges.add(
                    new Bridge(tuple.getItem1(), tuple.getItem2(), top, bottom)
            );

        return new Level(bridges, bricks);
    }


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

        ArrayList<Bridge> bridges = new ArrayList<>();
        bridges.add(new Bridge(10, 10, getSecondLevel(lvl), lvl));

        lvl.setBridges(bridges);


        return lvl;
    }

    public Level getSecondLevel(Level bottom) {
        ArrayList<Brick> bricks = new ArrayList<>();
        bricks.add(new Brick(24, 18));
        bricks.add(new Brick(24, 20));
        bricks.add(new Brick(24, 22));
        bricks.add(new Brick(24, 24));

        bricks.add(new Brick(8, 24));
        bricks.add(new Brick(10, 24));
        bricks.add(new Brick(12, 24));
        bricks.add(new Brick(14, 24));
        bricks.add(new Brick(16, 24));

        bricks.add(new Brick(16, 4));
        bricks.add(new Brick(18, 4));
        bricks.add(new Brick(20, 4));
        bricks.add(new Brick(22, 4));
        bricks.add(new Brick(24, 4));

        Level lvl = new Level(new ArrayList<Bridge>(), bricks);
        ArrayList<Bridge> bridges = new ArrayList<>();
        bridges.add(new Bridge(15, 15, lvl, bottom));
        lvl.setBridges(bridges);

        return lvl;
    }
}
