package ConnectFour;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.Rectangle;

/*
 * This Class creates the graphical board interface for our Connect Four game
 * Written by Josh Planko for the COMP 128 Final Project, Spring 2024
 */

public class Board {

    public static final int CANVAS_HEIGHT = 800;
    public static final int CANVAS_WIDTH = 600;

    public Board (CanvasWindow canvas){
        
        Rectangle board = new Rectangle(50, 150, 500, 450);
        board.setFillColor(Color.BLUE);
        canvas.add(board);

        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 6; i++){
                Ellipse slot = new Ellipse();
            }
        }


        canvas.draw();
    }

    public static void main (String[] args){
        CanvasWindow canvas = new CanvasWindow("Connect Four!", CANVAS_WIDTH, CANVAS_HEIGHT);
        new Board(canvas);
    }
}
