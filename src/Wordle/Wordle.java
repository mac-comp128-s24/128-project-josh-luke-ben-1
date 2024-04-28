package Wordle;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;

public class Wordle {
    
    public static final int CANVAS_HEIGHT = 800;
    public static final int CANVAS_WIDTH = 600;

    Background background;
    CanvasWindow canvas;
    String randomWord;

    public Wordle(){
        canvas = new CanvasWindow("Wordle", CANVAS_WIDTH, CANVAS_HEIGHT);
        background = new Background(canvas);

        Word word = new Word();
        randomWord = word.getRandomWord();

        if (background.getGuesses() == 6){
            background.loser(randomWord);
        }

        if (randomWord.equals(background.getEnteredWord())){
            background.winner(randomWord);
        }   

        List<Color> colors = compareWords(background.getEnteredWord(), randomWord);
        background.fillBoxes(colors);

        canvas.draw();
    }

    public List<Color> compareWords(String enteredWord, String randomWord) {
    List<Color> colors = new ArrayList<>();
    for (int i = 0; i < enteredWord.length(); i++) {
        char enteredLetter = enteredWord.charAt(i);
        char randomLetter = randomWord.charAt(i);
        if (enteredLetter == randomLetter) {
            colors.add(Color.GREEN);
        } else if (randomWord.indexOf(enteredLetter) != -1) {
            colors.add(Color.YELLOW);
        } else {
            colors.add(Color.GRAY);
        }
    }
    return colors;
}

    public String getRandomWord() {
        return randomWord;
    }

    public static void main(String[] args) {
        Wordle wordle = new Wordle();
    }
}
