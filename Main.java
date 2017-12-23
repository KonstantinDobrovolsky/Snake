package com.snake;

import com.snake.gui.Gui;

import javax.swing.*;

public class Main {

    private static final int MAIN_FRAME_WIDTH = 740;
    private static final int MAIN_FRAME_HEIGHT = 620;
    private static final String MAIN_FRAME_TITLE = "Snake";

    public static void main(String[] args) {
        JFrame frame = new JFrame(MAIN_FRAME_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(MAIN_FRAME_WIDTH, MAIN_FRAME_HEIGHT);
        frame.setResizable(false);

        Game game = new Game();

        Gui gui = new Gui(game);
        frame.add(gui);

        game.connectGUI(gui);

        game.Start();

        frame.addKeyListener(game);
        frame.setVisible(true);

    }
}
