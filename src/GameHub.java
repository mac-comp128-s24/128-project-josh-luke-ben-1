import java.awt.Color;

import ConnectFour.ConnectFour;
import Wordle.Wordle;
import edu.macalester.graphics.CanvasWindow;

import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;

import edu.macalester.graphics.ui.TextField;


//This class serves as the main hub for selecting which game you want to play. made by Luke Moore
public class GameHub {

private CanvasWindow canvas;
private GraphicsText titleText;
private TextField selectTextField;
private int nextY = 100;
private int nextb = 50;
private int CANVAS_HEIGHT = 400;
private int CANVAS_WIDTH = 750;
private ConnectFour connectFour;

    public GameHub(){


        canvas = new CanvasWindow("Game Hub", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(Color.BLUE);
        
        titleText = new GraphicsText("Welcome to the GameHub!");
        titleText.setCenter(CANVAS_WIDTH / 6.5, nextY);
        titleText.setFont(FontStyle.BOLD, 45);
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
        }else if (input.toLowerCase().equals("connect four")) {
            System.out.println("playing connect four");
            playConnectFour();
        }
    }
        
            

    public void addGame(String gameName) {
        GraphicsText gameText = new GraphicsText(gameName);
        gameText.setCenter(CANVAS_WIDTH / 3.8, nextY + nextb);
        gameText.setFillColor(Color.BLACK);
        gameText.setFont(FontStyle.BOLD, 65);
       
        canvas.add(gameText);

        nextb += 70;
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
        
        connectFour = new ConnectFour();
        
    }

    private static void playWordle() {
        
        Wordle wordle = new Wordle();
      
    }

    

    public static void main(String[] args) {
        GameHub gameHub = new GameHub();
        gameHub.addGame(" Connect Four");
        gameHub.addGame("Wordle");
       
    }
}