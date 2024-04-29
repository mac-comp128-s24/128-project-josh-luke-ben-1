import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import ConnectFour.ConnectFour;
import Wordle.Wordle;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.events.KeyboardEvent;
import edu.macalester.graphics.events.KeyboardEventHandler;
import edu.macalester.graphics.ui.TextField;


//This class serves as the main hub for selecting which game you want to play. made by Luke Moore
public class GameHub {

private CanvasWindow canvas;
private GraphicsText titleText;
private TextField selectTextField;
private int nextY = 100;
    public static final int CANVAS_HEIGHT = 800;
    public static final int CANVAS_WIDTH = 600;

    public GameHub(){


        canvas = new CanvasWindow("Game Hub", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(Color.PINK);
        
        titleText = new GraphicsText("Welcome to the Game Hub!");
        titleText.setCenter(230, nextY);
        titleText.setFont(FontStyle.BOLD, 24);
        canvas.add(titleText);
        
        nextY += 50;
        
        selectTextField = new TextField();
        selectTextField.setCenter(CANVAS_WIDTH / 2.0, nextY);
        selectTextField.onChange((changedText) -> processInput(changedText));
        canvas.add(selectTextField);
        nextY += 50;
        canvas.onKeyDown(null);

        }
    

    public void processInput(String input){
        

        if(input.toLowerCase().equals("wordle")){
            System.out.println("playing worlde");
            playWordle();
        }

      
    }

    public void addGame(String gameName) {
        GraphicsText gameText = new GraphicsText(gameName);
        gameText.setCenter(CANVAS_WIDTH / 2.0, nextY);
        gameText.setFillColor(Color.BLUE);
       
        canvas.add(gameText);

        nextY += 50;
    }

    public void selectGame() {
        String selectedGame = selectTextField.getText();
        
        switch (selectedGame.toLowerCase()) {
            case "connect four":
                playConnectFour();
                break;
            case "wordle":
                playWordle();
                break;
            default:
                System.out.println("Invalid game selection!");
        }
    }

    private void playConnectFour() {
        
        ConnectFour connectFour = new ConnectFour();
        
    }

    private static void playWordle() {
        
        Wordle wordle = new Wordle();
      
    }
  
    public static void main(String[] args) {
        GameHub gameHub = new GameHub();
        gameHub.addGame("Connect Four");
        gameHub.addGame("Wordle");
       
    }
}