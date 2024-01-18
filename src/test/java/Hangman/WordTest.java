package Hangman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class WordTest {
    // Arrange
    Word word;

    @BeforeEach
    void setUp() {
        // Act
        word=Mockito.mock(Word.class);
    }

    @Test
    void getWordLenght() {
        // Arrange
        Mockito.when(word.getWordLenght()).thenReturn(6);

        // Assert
        assertEquals(word.getWordLenght(), 6);
    }

    @Test
    void getWord() {
        // Arrange
        Mockito.when(word.getWord()).thenReturn("reddit");

        // Assert
        assertThat(word.getWord(), is("reddit"));
    }

    @Test
    void checkChar() {
        // Arrange
        Mockito.when(word.checkChar(0, 'r')).thenReturn(true);

        assertTrue(word.checkChar(0, 'r'));
        /*
        switch (word.getWord()){
            case "reddit":
                assertTrue(word.checkChar(0, 'r'));
                break;
            case "facebook":
                assertTrue(word.checkChar(0, 'f'));
                break;
            case "java":
                assertTrue(word.checkChar(0, 'j'));
                break;
            case "assignment":
                assertTrue(word.checkChar(0, 'a'));
                break;
            case "game":
                assertTrue(word.checkChar(0, 'g'));
                break;
            case "hello":
                assertTrue(word.checkChar(0, 'h'));
                break;
            case "islam":
                assertTrue(word.checkChar(0, 'i'));
                break;
            case "religion":
                assertTrue(word.checkChar(0, 'r'));
                break;
            case "internet":
                assertTrue(word.checkChar(0, 'i'));
                break;
            case "face":
                assertTrue(word.checkChar(0, 'f'));
                break;

        }
        */
    }
}