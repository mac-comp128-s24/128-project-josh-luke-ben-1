package ConnectFour;

import edu.macalester.graphics.CanvasWindow;

/**
* This Class creates the Connect Four Game and allows for the game hub to add this as an option
* Written by Josh Planko for the Comp 128 Final Project, Spring 2024
*/

public class ConnectFour {
    private Board board;
    private CanvasWindow canvas;
    
    public ConnectFour(){
        canvas = new CanvasWindow("Connect Four", Board.CANVAS_WIDTH, Board.CANVAS_HEIGHT);
        board = new Board(canvas);

    }
}
