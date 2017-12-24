package com.snake.model;
import java.util.ArrayList;

public class Level {
    private ArrayList<Bridge> bridges;
    private ArrayList<Brick> bricks;

    public ArrayList<Brick> getBricks() {
        return bricks;
    }

    public void setBridges(ArrayList<Bridge> newBridges){
        bridges = newBridges;
    }

    public int indexInBridges(Rectangle point) {
        //noinspection SuspiciousMethodCalls
        return bridges.indexOf(point);
    }

    public boolean isInBricks(Rectangle point) {
        //noinspection SuspiciousMethodCalls
        return bricks.contains(point);
    }

    public Bridge getBridge(int index) {
        return bridges.get(index);
    }

    public ArrayList<Bridge> getBridges() {
        return bridges;
    }

    public Level() {
        bricks = new ArrayList<>();
        bridges = new ArrayList<>();
    }

    public Level(ArrayList<Bridge> bridges, ArrayList<Brick> bricks) {
        this.bridges = bridges;
        this.bricks = bricks;
    }

    public void addBridges(ArrayList<Bridge> bridges) {
        this.bridges.addAll(bridges);
    }

    public void addBricks(ArrayList<Brick> bricks) {
        this.bricks.addAll(bricks);
    }
}
