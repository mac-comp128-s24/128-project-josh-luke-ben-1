import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
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
        titleText.setCenter(CANVAS_WIDTH / 2.0, nextY);
        titleText.setFont(FontStyle.BOLD, 24);
        canvas.add(titleText);

        nextY += 50;

        selectTextField = new TextField();
        selectTextField.setCenter(CANVAS_WIDTH / 2.0, nextY);
        canvas.add(selectTextField);

        nextY += 50;
    }

    public void addGame(String gameName) {
        GraphicsText gameText = new GraphicsText(gameName);
        gameText.setCenter(CANVAS_WIDTH / 2.0, nextY);
        gameText.setFillColor(Color.BLUE);
       
        canvas.add(gameText);

        nextY += 30;
    }

    private void selectGame() {
        String selectedGame = selectTextField.getText();
       
        System.out.println("Selected game: " + selectedGame);
    }

    private void selectGame(String gameName) {
       
        System.out.println("Selected game: " + gameName);
    }

    public static void main(String[] args) {
        GameHub gameHub = new GameHub();
        gameHub.addGame("Connect Four");
        gameHub.addGame("Wordle");
    }
}