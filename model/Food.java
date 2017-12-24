package com.snake.model;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Food {
    private Rectangle NotAlcoholicFood;
    private Rectangle AlcoholicFood;
    private Rectangle DiedFood;
    public Image picNotAlcoholicFood;
    public Image picAlcoholicFood;
    public Image picDeadlyFood;
    private Random random;
    private int Width;
    private int Height;

    public Food()
    {
        NotAlcoholicFood  = new Rectangle();
        AlcoholicFood = new Rectangle();
        DiedFood = new Rectangle();
        random = new Random();
        Width = 570;
        Height = 570;

        generateAllFood();
        loadImages();
    }

    public Rectangle getNotAlcoholicFood() {
        return NotAlcoholicFood;
    }

    public void setNotAlcoholicFood(Rectangle food) {
        NotAlcoholicFood = food;
    }

    public void setAlcoholicFood(Rectangle food) {
        AlcoholicFood = food;
    }

    public void setDiedFood(Rectangle food) {
        DiedFood = food;
    }

    public Rectangle getAlcoholicFood() {
        return AlcoholicFood;
    }

    public Rectangle getDiedFood() {
        return DiedFood;
    }

    public Rectangle generateFood()
    {
        Rectangle food = new Rectangle();
        food.setX(random.nextInt(
                Width / Tools.getWidth()));
        food.setY(random.nextInt(
                Height / Tools.getHeight()));
        return food;
    }

    public void generateNotAlcoholicFood()
    {
        NotAlcoholicFood = generateFood();
        while (NotAlcoholicFood.Equals(DiedFood)
                || NotAlcoholicFood.Equals(AlcoholicFood))
        {
            NotAlcoholicFood = generateFood();
        }
    }

    public void generateAlcoholicFood()
    {
        AlcoholicFood = generateFood();
        while (AlcoholicFood.Equals(DiedFood)
                || AlcoholicFood.Equals(NotAlcoholicFood))
        {
            AlcoholicFood = generateFood();
        }
    }

    public void  generateDeadlyFood()
    {

    }
    public void generateAllFood()
    {
        NotAlcoholicFood = generateFood();
        AlcoholicFood = generateFood();
        while (AlcoholicFood.Equals(NotAlcoholicFood))
        {
            AlcoholicFood = generateFood();
        }
        DiedFood = generateFood();
        while (DiedFood.Equals(NotAlcoholicFood)
                || DiedFood.Equals(AlcoholicFood))
        {
            DiedFood = generateFood();
        }
    }

    private void loadImages(){
        ImageIcon na = new ImageIcon("pic\\food.png");
        picNotAlcoholicFood = na.getImage();

        ImageIcon af = new ImageIcon("pic\\alcoholFood.png");
        picAlcoholicFood = af.getImage();

        ImageIcon df = new ImageIcon("pic\\deadlyFood.png");
        picDeadlyFood = df.getImage();
    }
}


