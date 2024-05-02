package ConnectFour;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;

/**
 * This Class creates the graphical board interface for our Connect Four game and checks for the win condition of the game
 * Written by Josh Planko for the COMP 128 Final Project, Spring 2024
 */

public class Board {

    public static final int CANVAS_HEIGHT = 800;
    public static final int CANVAS_WIDTH = 600;
    public String columnInput;
    public char[][] boardArray;
    public char player = 'R';
    private GraphicsText welcomeText;

    public Board (CanvasWindow canvas){

        boardArray = new char[6][7];

        for (int row = 0; row < boardArray.length; row++){
			for (int col = 0; col < boardArray[0].length; col++){
				boardArray[row][col] = ' ';
		}
        
        Rectangle board = new Rectangle(50, 150, 500, 450);
        board.setFillColor(Color.BLUE);
        canvas.add(board);

        double slotX = 5;
        double textY = 625;
        for (int i = 0; i < 7; i++){
            double slotY = 193;
            slotX += 68;
            GraphicsText columnNumber = new GraphicsText("" + (i), slotX + 20, textY);
            canvas.add(columnNumber);
            for (int j = 0; j < 6; j++){
                Ellipse slot = new Ellipse(slotX, slotY, Piece.PIECE_RADIUS*2, Piece.PIECE_RADIUS * 2);
                slot.setFillColor(Color.WHITE);
                canvas.add(slot);
                slotY += 68;
            }
        }

        welcomeText = new GraphicsText("Welcome to Connect Four!", 60, 50);
        welcomeText.setFontSize(40);
        canvas.add(welcomeText);

        GraphicsText whatColumn = new GraphicsText("What column do you want to place your piece in?", 60, 125);
        canvas.add(whatColumn);

        TextField input = new TextField();
        input.setBackground(Color.GRAY);

        canvas.add(input, 375, 112);

        Button enterButton = new Button("Enter");
        enterButton.onClick(() -> {
            int inputC;
            columnInput = input.getText();
            columnInput.trim();
            inputC = Integer.valueOf(columnInput);
            addPiece(inputC, canvas);
            input.setText("");
        });

        canvas.add(enterButton, 500, 112);

        Piece p1 = new Piece (50, 675, Piece.PIECE_RADIUS*2, Piece.PIECE_RADIUS*2, Color.RED, 'R');
        canvas.add(p1);

        Piece p2 = new Piece (550, 675, Piece.PIECE_RADIUS*2, Piece.PIECE_RADIUS*2, Color.YELLOW, 'Y');
        canvas.add(p2);

        canvas.draw();
    }
}

    /**
     * This function adds the visual piece to the visual board, adds the data piece to the character matrix, and checks the win condition after each piece is played
     * @param input the column input that a plyaer wants to put their piece in
     * @param canvas the canvas window
     */

    public void addPiece(int input, CanvasWindow canvas){     
        for(int i = 5; i >= 0; i--){

            if (boardArray[i][input] == ' '){

                boardArray[i][input] = player;
                Piece newPiece = new Piece(98 + 68 * input, (218 + 68 * i), Piece.PIECE_RADIUS*2, Piece.PIECE_RADIUS*2, Color.WHITE, player);
                canvas.add(newPiece);

                if (isWinner(player, boardArray) == true){
                    canvas.removeAll();
                    GraphicsText endText = new GraphicsText("");
                    if (player == 'R'){
                        endText.setText("Yellow has won the game!!");
                    } else if (player == 'Y') {
                        endText.setText("Red has won the game!!");
                    }
                    endText.setFontSize(50);
                    endText.setCenter(300, 400);
                    canvas.add(endText);
                    canvas.draw();
                }

                if (player == 'R'){
                    player = 'Y';
                } else if (player == 'Y') {
                    player = 'R';
                }

                if(player == 'R'){
                    newPiece.setFillColor(Color.RED);
                } else if(player == 'Y'){
                    newPiece.setFillColor(Color.YELLOW);
                }

                break;
            }
            
        }
        canvas.draw();
    }

    /**
     * This function defines the conditions for winning the game and checks the data board for the win condition
     * Found online from jonathan-irvin GitHub page and adjusted to fit my version of connect four (his used the terminal to display his output)
     * @param player the character representation of the player that we are checking the win condition for
     * @param grid the char matrix data board that stores the locations of already places pieces
     * @return either true or false on whether the current player is a winner
     */

    public boolean isWinner(char player, char[][] grid){
		//check for 4 across
		for(int row = 0; row<grid.length; row++){
			for (int col = 0;col < grid[0].length - 3;col++){
				if (grid[row][col] == player   && 
					grid[row][col+1] == player &&
					grid[row][col+2] == player &&
					grid[row][col+3] == player){
					return true;
				}
			}			
		}
		//check for 4 up and down
		for(int row = 0; row < grid.length - 3; row++){
			for(int col = 0; col < grid[0].length; col++){
				if (grid[row][col] == player   && 
					grid[row+1][col] == player &&
					grid[row+2][col] == player &&
					grid[row+3][col] == player){
					return true;
				}
			}
		}
		//check upward diagonal
		for(int row = 3; row < grid.length; row++){
			for(int col = 0; col < grid[0].length - 3; col++){
				if (grid[row][col] == player   && 
					grid[row-1][col+1] == player &&
					grid[row-2][col+2] == player &&
					grid[row-3][col+3] == player){
					return true;
				}
			}
		}
		//check downward diagonal
		for(int row = 0; row < grid.length - 3; row++){
			for(int col = 0; col < grid[0].length - 3; col++){
				if (grid[row][col] == player   && 
					grid[row+1][col+1] == player &&
					grid[row+2][col+2] == player &&
					grid[row+3][col+3] == player){
					return true;
				}
			}
		}
		return false;
	}

    /**
     * Getter methods
     */

    public char getPlayer(){
        return player;
    }

    public char[][] getBoardArray(){
        return boardArray;
    }


}
