package ConnectFour;

import edu.macalester.graphics.CanvasWindow;

public class DataBoard {
    private int[][] data;
    private Board board;
    private long p1Bitboard;
    private long maskBitboard;
    private CanvasWindow canvas;


    public DataBoard(int[][] data){
        data = new int[7][7];
        board = new Board(canvas);
        p1Bitboard = 0b0000000000000000000000000000000000000000000000000L;
        maskBitboard = 0b0000000000000000000000000000000000000000000000000L;
    }

    public void makeMove(long currentP1, long currentMask, int columnInput){
        long newP1 = currentP1 ^ currentMask;
        long newMask = currentMask | (currentMask + (1 << (columnInput * 7)));
        p1Bitboard = newP1;
        maskBitboard = newMask;
    }

    // public long getPositionMaskBitmap(){

    // }

    public int[][] getData(){
        return data;
    }
}
