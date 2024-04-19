package Wordle;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.TextField;

public class Background{
    
    public static final int CANVAS_HEIGHT = 800;
    public static final int CANVAS_WIDTH = 600;


    public Background(CanvasWindow canvas){
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 6; j++){
                Rectangle square = new Rectangle(55 + i*60, 200 + j*60,90,90);
                canvas.add(square);
            }
        }

        GraphicsText welcomeText = new GraphicsText("WORDLE", 200, 50);
        welcomeText.setFontSize(40);
        canvas.add(welcomeText);

        GraphicsText word = new GraphicsText("Enter a 5 letter word", 150, 125);
        canvas.add(word);

        TextField input = new TextField();
        canvas.add(input, 300, 150);

        canvas.draw();

    }


    public static void main(String[] args){
        CanvasWindow canvas = new CanvasWindow("Wordle", CANVAS_WIDTH, CANVAS_HEIGHT);
        new Background(canvas);
    }
}
