package com.snake;
import com.snake.gui.AbstractGUI;
import com.snake.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener {
    private Food SnakeFood;
    private Snake MySnake;
    private Tools tools;
    private int keyPressed;
    private Consequences cons;
    private Level level;
    public Image picBackground;

    private AbstractGUI gui;

    public Food getFood() {
        return SnakeFood;
    }

    public Snake getMySnake() {
        return MySnake;
    }

    public Tools getTools() {
        return tools;
    }

    public Level getLevel() {return level; }

    public void setTools(Tools tool) {
        tools = tool;
    }

    public Consequences getCons() {
        return cons;
    }

    public Game()
    {
        SnakeFood = new Food();
        MySnake = new Snake();
        tools = new Tools();
        tools.setIsGameOver(true);
        ImageIcon na = new ImageIcon("pic\\background.png");
        picBackground = na.getImage();
    }

    public void connectGUI(AbstractGUI gui) {
        this.gui = gui;
    }

    public void Start() {
        javax.swing.Timer timer = new Timer(100, this::makeMove);
        timer.start();
    }
    public void startNewGame()
    {
        SnakeFood = new Food();
        MySnake = new Snake();
        tools = new Tools();

        level = new Levels().getFirstLevel();
        cons = new Consequences(MySnake, SnakeFood, tools, level);
    }

    private void makeMove(ActionEvent evt) {
        if (!tools.getIsGameOver()) {
            moveSnake();
            gui.fireRepaint();
        }
    }

    private void ChangeKeyPressed()
    {
        if (keyPressed == KeyEvent.VK_DOWN) {
            keyPressed = KeyEvent.VK_UP;
        }
        else {
            if (keyPressed == KeyEvent.VK_UP) {
                keyPressed = KeyEvent.VK_DOWN;
            }
        }
        if (keyPressed == KeyEvent.VK_LEFT) {
            keyPressed = KeyEvent.VK_RIGHT;
        }
        else {
            if (keyPressed == KeyEvent.VK_RIGHT) {
                keyPressed = KeyEvent.VK_LEFT;
            }
        }
    }
    public void moveSnake() {
        if (keyPressed == KeyEvent.VK_DOWN) {
            if (tools.getDirection() != Direction.Up) {
                tools.setDirection(Direction.Down);
            }
        }
        if (keyPressed == KeyEvent.VK_UP) {
            if (tools.getDirection() != Direction.Down) {
                tools.setDirection(Direction.Up);
            }
        }
        if (keyPressed == KeyEvent.VK_LEFT) {
            if (tools.getDirection() != Direction.Right) {
                tools.setDirection(Direction.Left);
            }
        }
        if (keyPressed == KeyEvent.VK_RIGHT) {
            if (tools.getDirection() != Direction.Left) {
                tools.setDirection(Direction.Right);
            }
        }

        if (!tools.getIsGameOver())
            cons.recountConsequences();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyPressed = e.getKeyCode();
        if (MySnake.getAlcohol() == -1)
            ChangeKeyPressed();
        moveSnake();
        if (keyPressed == KeyEvent.VK_ENTER && tools.getIsGameOver())
            startNewGame();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}