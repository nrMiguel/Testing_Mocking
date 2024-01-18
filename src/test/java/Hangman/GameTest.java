package Hangman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game;

    @BeforeEach
    void setUp() {
        game= new Game();
    }

    @Test
    void isTheWordGuessed() {
        // Arrange
        char[] wordArray ={'r', 'e', 'd', 'd', 'i', 't'};

        // Assert
        assertTrue(game.isTheWordGuessed(wordArray));
    }
}