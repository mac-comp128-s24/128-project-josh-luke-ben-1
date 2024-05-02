import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void winConditionTest(){
        CanvasWindow canvas = new CanvasWindow("Connect Four!", CANVAS_WIDTH, CANVAS_HEIGHT);
        Board board = new Board(canvas);
        char[][] grid = board.getBoardArray();
        grid[0][0] = 'R';
        grid[0][1] = 'R';
        grid[0][2] = 'R';
        grid[0][3] = 'R';
        assertTrue(board.isWinner('R', grid));
        char[][] grid1 = board.getBoardArray();
        grid1[0][0] = 'R';
        grid1[1][0] = 'R';
        grid1[2][0] = 'R';
        grid1[3][0] = 'R';
        assertTrue(board.isWinner('R', grid1));
        char[][] grid2 = board.getBoardArray();
        grid2[0][0] = 'Y';
        grid2[1][1] = 'Y';
        grid2[2][2] = 'Y';
        grid2[3][3] = 'Y';
        assertTrue(board.isWinner('Y', grid2));
        char[][] grid3 = board.getBoardArray();
        grid3[0][4] = 'Y';
        grid3[1][3] = 'Y';
        grid3[2][2] = 'Y';
        grid3[3][1] = 'Y';
        assertTrue(board.isWinner('Y', grid3));
        char[][] grid4 = new char[6][7];
        grid4[0][0] = 'R';
        grid4[0][1] = 'R';
        grid4[0][2] = 'Y';
        grid4[0][3] = 'R';
        assertFalse(board.isWinner('Y', grid4));
    }
}
