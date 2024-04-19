import org.junit.jupiter.api.Test;

import ConnectFour.Board;
import edu.macalester.graphics.CanvasWindow;

public class CFVisualTester {

    public static final int CANVAS_WIDTH = 600;
    public static final int CANVAS_HEIGHT = 800;
    
    @Test
    public void CFInterfaceTest(){
        CanvasWindow canvas = new CanvasWindow("Connect Four!", CANVAS_WIDTH, CANVAS_HEIGHT);
        new Board(canvas);
    }
}
