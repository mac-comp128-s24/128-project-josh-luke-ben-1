import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import ConnectFour.Board;
import Wordle.Word;
import edu.macalester.graphics.CanvasWindow;

public class WordleTests {
    
    @Test
    public void isWordTest(){
        Word wordObject = new Word();
        wordObject.readWordsFromFile();

        assertFalse(wordObject.isWord("xxxxx"));
        assertTrue(wordObject.isWord("apple"));
    }


}
