package Wordle;

import java.util.List;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;
import java.awt.Color;

public class Background{
    
    public static final int CANVAS_HEIGHT = 800;
    public static final int CANVAS_WIDTH = 600;

    TextField input;
    String enteredWord;
    CanvasWindow canvas;
    int guesses;
    Wordle wordle;
    Word wordObject;

    public Background(CanvasWindow canvas, Wordle wordle, String randWord){
        this.canvas = canvas;
        this.wordle = wordle;
        guesses = 0;

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

        GraphicsText wordsGuessed = new GraphicsText("Words Guessed:", 10, 20);
        canvas.add(wordsGuessed);

        input = new TextField();
        canvas.add(input, 300, 80);

        wordObject = new Word();
        wordObject.readWordsFromFile();

        Button enterButton = new Button("Enter");
        enterButton.onClick(() -> {
            enteredWord = input.getText();
            if(enteredWord.length() == 5 && wordObject.isWord(enteredWord)){ 
                List<Color> colors = wordle.compareWords(enteredWord, randWord);
                fillBoxes(colors);
                guesses++;

                GraphicsText wordguess = new GraphicsText(enteredWord, 10, 20*guesses + 20);
                canvas.add(wordguess);
    
                if (guesses == 6){
                    loser(randWord);
                }
        
                if (randWord.equals(enteredWord)){
                    winner(randWord);
                }   
            }
        });
        canvas.add(enterButton, 450, 80);

        canvas.draw();
    }

    public String getEnteredWord() {
        return enteredWord;
    }

    public int getGuesses() {
        return guesses;
    }

    public void winner(String theWord){
        canvas.removeAll();
        GraphicsText winner = new GraphicsText("WINNER!", 180, 300);
        winner.setFontSize(50);
        canvas.add(winner);

        GraphicsText word = new GraphicsText("Word: " + theWord, 175, 400);
        word.setFontSize(50);
        canvas.add(word);

        canvas.draw();
    }

    public void loser(String theWord){
        canvas.removeAll();
        GraphicsText winner = new GraphicsText("You lose :(", 180, 300);
        winner.setFontSize(50);
        canvas.add(winner);

        GraphicsText word = new GraphicsText("Word: " + theWord, 175, 400);
        word.setFontSize(50);
        canvas.add(word);

        canvas.draw();
    }

    public void fillBoxes(List<Color> colors) {
        for (int i = 0; i < 5; i++){
            Rectangle square = new Rectangle(55 + i*100, 140 + guesses*100,90,90);
            square.setFillColor(colors.get(i));
            canvas.add(square);
        }
        canvas.draw();
    }

    

}
