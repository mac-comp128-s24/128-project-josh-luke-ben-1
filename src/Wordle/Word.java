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

/**
 * This Class takes the txt file containing valid wordle words and converts it into an ArrayList. This class also picks and random word and 
 * check whether a word given is in the list of valid words.
 * Written by Benjamin King for the COMP 128 Final Project, Spring 2024
 */
public class Word {
    private List<String> words;

    public Word() {
        words = new ArrayList<>();
    }

    /**
    * This function adds the words from the txt file into an arraylist
    */
    public void readWordsFromFile() {
        try {
            words = Files.readAllLines(Paths.get("C:\\Users\\benki\\OneDrive\\Documents\\GitHub\\128-project-josh-luke-ben-1\\src\\Wordle\\valid-wordle-words.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    * This function picks a random word from the valid wordle words arraylist
    */
    public String pickRandomWord() {
        Random rand = new Random();
        return words.get(rand.nextInt(words.size()));
    }

    /**
    * getter methods
    */
    public List<String> getWords() {
        return words;
    }

    /**
    * This function checks whether a word is in the valid wordle words list
    * @param word word inputed into the user interface
    */
    public boolean isWord(String word){
        boolean output = false;
        for(String w : words){
            if (word.equals(w)){
                output = true;
                break;
            }
        }
        return output;
    }
}
