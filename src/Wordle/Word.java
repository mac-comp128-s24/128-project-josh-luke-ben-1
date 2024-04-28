package Wordle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Word {
    private List<String> words;

    public Word() {
        words = new ArrayList<>();
    }

    public void readWordsFromFile() {
        try {
            words = Files.readAllLines(Paths.get("C:\\Users\\benki\\OneDrive\\Documents\\GitHub\\128-project-josh-luke-ben-1\\src\\Wordle\\valid-wordle-words.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRandomWord() {
        Random rand = new Random();
        return words.get(rand.nextInt(words.size()));
    }

    
}
