package ConnectFour;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.TextField;

/**
 * This Class creates the graphical board interface for our Connect Four game
 * Written by Josh Planko for the COMP 128 Final Project, Spring 2024
 */

public class Board {

    public static final int CANVAS_HEIGHT = 800;
    public static final int CANVAS_WIDTH = 600;
    public String columnInput;
    private String intermediate;

    public Board (CanvasWindow canvas){
        
        Rectangle board = new Rectangle(50, 150, 500, 450);
        board.setFillColor(Color.BLUE);
        canvas.add(board);

        double slotX = 5;
        double textY = 625;
        for (int i = 0; i < 7; i++){
            double slotY = 193;
            slotX += 68;
            GraphicsText columnNumber = new GraphicsText("" + (i + 1), slotX + 20, textY);
            canvas.add(columnNumber);
            for (int j = 0; j < 6; j++){
                Ellipse slot = new Ellipse(slotX, slotY, Piece.PIECE_RADIUS*2, Piece.PIECE_RADIUS * 2);
                slot.setFillColor(Color.WHITE);
                canvas.add(slot);
                slotY += 68;
            }
        }

        GraphicsText welcomeText = new GraphicsText("Welcome to Connect Four!", 60, 50);
        welcomeText.setFontSize(40);
        canvas.add(welcomeText);

        GraphicsText whatColumn = new GraphicsText("What column do you want to place your piece in?", 60, 125);
        canvas.add(whatColumn);

        TextField input = new TextField();
        input.setBackground(Color.GRAY);
        input.onChange(intermediate->{
            if (intermediate.endsWith("\n")){
                columnInput = intermediate.trim();
                input.setText("");
            }
        });
        
        canvas.add(input, 375, 112);

        Piece p1 = new Piece (50, 675, Piece.PIECE_RADIUS*2, Piece.PIECE_RADIUS*2, Color.RED, 1);
        canvas.add(p1);

        Piece p2 = new Piece (550, 675, Piece.PIECE_RADIUS*2, Piece.PIECE_RADIUS*2, Color.YELLOW, 2);
        canvas.add(p2);

        canvas.draw();
    }

    public static void main (String[] args){
        CanvasWindow canvas = new CanvasWindow("Connect Four!", CANVAS_WIDTH, CANVAS_HEIGHT);
        new Board(canvas);
        
    }
}
