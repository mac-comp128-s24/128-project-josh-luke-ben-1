package Wordle;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;

public class Background{
    
    public static final int CANVAS_HEIGHT = 800;
    public static final int CANVAS_WIDTH = 600;


    public Background(CanvasWindow canvas){

        

        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 6; j++){
                Rectangle square = new Rectangle(i*60,j*60,50,50);
                canvas.add(square);
            }
        }

        canvas.draw();

    }

}
