package Wordle;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.TextField;

public class Background{
    
    public static final int CANVAS_HEIGHT = 800;
    public static final int CANVAS_WIDTH = 600;

    TextField input;

    public Background(CanvasWindow canvas){
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 6; j++){
                Rectangle square = new Rectangle(55 + i*100, 140 + j*100,90,90);
                canvas.add(square);
            }
        }

        GraphicsText welcomeText = new GraphicsText("WORDLE", 200, 50);
        welcomeText.setFontSize(40);
        canvas.add(welcomeText);

        GraphicsText word = new GraphicsText("Enter a 5 letter word", 150, 95);
        canvas.add(word);

        input = new TextField();
        canvas.add(input, 300, 80);

        canvas.draw();

    }

    public TextField getInput() {
        return input;
    }

    public static void main(String[] args){
        CanvasWindow canvas = new CanvasWindow("Wordle", CANVAS_WIDTH, CANVAS_HEIGHT);
        new Background(canvas);
    }
}
