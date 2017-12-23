package com.snake.model;

import com.snake.model.Direction;

public class Tools {
    private static int Height = 20;
    private static int Width = 20;
    private static int Size = Height;
    private static int maxX = 570 / Size;
    private static int maxY = 570 / Size;
    private static Direction Direction;

    private static int TravelingSpeed = 15;

    private static int TotalScore;
    private static int ScoreForFood;
    private static boolean IsGameOver;

    public static int getHeight() {
        return Height;
    }

    public static void setHeight(int height) {
        Height = height;
    }

    public static int getWidth() {
        return Width;
    }

    public static void setWidth(int width)
    {
        Width = width;
    }

    public static int getMaxX() { return maxX; }

    public static int getMaxY() { return maxY; }

    public static int getSize() {
        return Size;
    }

    public com.snake.model.Direction getDirection() {
        return Direction;
    }

    public void setDirection(com.snake.model.Direction direction) {
        Direction = direction;
    }

    public static int getTravelingSpeed() {
        return TravelingSpeed;
    }

    public int getTotalScore() {
        return TotalScore;
    }

    public void setTotalScore(int totalScore) {
        TotalScore = totalScore;
    }

    public static int getScoreForFood() {
        return ScoreForFood;
    }

    public static void setScoreForFood(int scoreForFood) {
        ScoreForFood = scoreForFood;
    }

    public boolean getIsGameOver()
    {
        return IsGameOver;
    }

    public void setIsGameOver(boolean isGameOver)
    {
        IsGameOver = isGameOver;
    }

    public Tools()
    {
        Width = 20;
        Height = 20;
        Direction = Direction.Up;

        TotalScore = 0;
        ScoreForFood = 1;
        IsGameOver = false;
    }


}
