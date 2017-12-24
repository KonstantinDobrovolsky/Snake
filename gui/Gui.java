package com.snake.gui;
import com.snake.Game;
import com.snake.model.*;
import com.snake.model.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Gui extends JPanel implements AbstractGUI {

    private Game game;

    public Gui(Game game)
    {
        this.game = game;
    }

    public void draw(ActionEvent evt)
    {
        repaint();
    }
    public void paintFood1(Graphics g, Rectangle food)
    {
        g.fillRect(food.getX() * Tools.getSize(), food.getY() * Tools.getSize(),
                Tools.getSize(), Tools.getSize());
    }

    public void paintFood(Graphics g, Food food)
    {
        g.drawImage(food.picNotAlcoholicFood, food.getNotAlcoholicFood().getX() * Tools.getSize(),
                food.getNotAlcoholicFood().getY() * Tools.getSize(), this);

        g.drawImage(food.picAlcoholicFood, food.getAlcoholicFood().getX()* Tools.getSize(),
                food.getAlcoholicFood().getY()* Tools.getSize(), this);

        g.drawImage(food.picDeadlyFood, food.getDiedFood().getX()* Tools.getSize(),
                food.getDiedFood().getY()* Tools.getSize(),this);
    }

    public void paintLevel(Graphics g, Level level){
        for(Brick brick: level.getBricks()){
            g.drawImage(brick.picBrick,
                    brick.getX() * Tools.getSize(),
                    brick.getY() * Tools.getSize(), this);
        }

        for (Bridge bridge: level.getBridges()){
            g.drawImage(bridge.picBridge,
                    bridge.getX() * Tools.getSize(),
                    bridge.getY() * Tools.getSize(), this);
        }
    }

    public void paintSnake(Graphics g, Snake snake){
        g.drawImage(snake.getSnakeHeadPic(),
                snake.getSnakeHead().getX() * Tools.getSize(),
                snake.getSnakeHead().getY() * Tools.getSize(), this);

        for (com.snake.model.Rectangle i : game.getMySnake().getBody()) {
            g.drawImage(snake.getSnakeBodyPic(),
                    i.getX() * Tools.getSize(),
                    i.getY() * Tools.getSize(), this);
        }
    }

    public void drawInformationPanel(Graphics g)
    {

        Font font1 = new Font("Serif", Font.PLAIN, 30);
        g.setFont(font1);
        g.setColor(Color.BLUE);
        g.drawString("Food Color:", 580, 50);
        g.setColor(Color.BLACK);
        g.drawString("Died Food", 590, 110);

        g.setColor(Color.green);
        g.drawString("Good Food", 590, 160);

        g.setColor(Color.orange);
        g.drawString("Alcoholic", 590, 210);
        g.drawString("Food", 590, 240);

        g.setColor(Color.red);
        g.drawString("SCORE:", 590, 380);

        g.drawString(String.valueOf(game.getTools().getTotalScore()), 590, 420);

    }

    public void paint(Graphics g)
    {
        super.paintComponent(g);
        drawInformationPanel(g);

        if (!game.getTools().getIsGameOver()) {

            g.drawImage(game.picBackground,
                    0 * Tools.getSize(),
                    0 * Tools.getSize(), this);

            paintSnake(g, game.getMySnake());

            paintFood(g, game.getFood());

            paintLevel(g, game.getLevel());

            g.setColor(Color.red);
            g.drawLine(0, 575, 575, 575);
            g.drawLine(575, 0, 575, 575);
        }
        else
        {
            g.setColor(Color.red);
            Font font = new Font("Serif", Font.PLAIN, 96);
            g.setFont(font);
            g.drawString("Start game", 100, 250);

            g.setColor(Color.red);
            Font font1 = new Font("Serif", Font.PLAIN, 40);
            g.setFont(font1);
            g.drawString("Press enter to start", 100, 350);
        }
    }

    @Override
    public void fireRepaint() {
        repaint();
    }
}