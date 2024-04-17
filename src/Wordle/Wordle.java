package Wordle;

import edu.macalester.graphics.CanvasWindow;

public class Wordle {
    
    public static final int CANVAS_HEIGHT = 800;
    public static final int CANVAS_WIDTH = 600;

    Background background;
    CanvasWindow canvas;

    public Wordle(){
        CanvasWindow canvas = new CanvasWindow("Wordle", CANVAS_WIDTH, CANVAS_HEIGHT);
        background = new Background(canvas);

    }

    public void run(){
        Wordle wordle = new Wordle();
    }

}
