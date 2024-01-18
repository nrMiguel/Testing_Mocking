package Hangman;

import java.util.Scanner;

public class Game {
    public void start(boolean testMode){
        Scanner scanner = new Scanner(System.in);
        char[] playerGuess;
        boolean weArePlaying = true;
        boolean wordIsGuessed = false;
        while(weArePlaying){
            System.out.println("Lets Start Playing Hangman ver 0.3");
            Word wordtoGuess = new Word();
            if (testMode) {
                System.out.println("Test mode, word to guess:" + "\033[34m" + wordtoGuess.getWord() + "\u001B[0m");
            }
            int tries = 0, fails =0;
            playerGuess = new char[wordtoGuess.getAmmountOfGuesses()]; // "_ _ _ _ _ _ _ _"

            for (int i = 0; i < playerGuess.length; i++) { // Assign empty dashes at start "_ _ _ _ _ _ _ _"
                playerGuess[i] = '_';
            }

            while(!wordIsGuessed && fails != wordtoGuess.getAmmountOfGuesses()){
                System.out.println("Current Guesses: ");
                print(playerGuess);
                System.out.printf("You have %d ammount of tries left.\n", wordtoGuess.getAmmountOfGuesses()-tries);
                System.out.println("Enter a single character: ");
                char input=Character.MIN_VALUE;
                String controlInput="";
                boolean correcto = false;

                while (!correcto) {
                    controlInput= scanner.nextLine();
                    if (controlInput.equals("")){
                        System.out.println("No se admiten entradas de texto vacías, introduce de nuevo:");
                    } else {
                        input=controlInput.charAt(0);
                        correcto=true;
                    }
                }

                tries++;

                boolean found = false;
                for(int i=0; i< wordtoGuess.getWordLenght(); i++){
                    if(wordtoGuess.checkChar(i,input)){
                        playerGuess[i] = input;
                        found = true;
                    }
                }
                if(!found){
                    fails++;
                }
                if(isTheWordGuessed(playerGuess)){
                    wordIsGuessed = true;
                    System.out.println("\033[36m" +"Congratulations" + "\u001B[0m");
                }

            } /* End of wordIsGuessed */
            if(!wordIsGuessed){
                System.out.println("\033[31m" +"You ran out of guesses." + "\u001B[0m");
            }

            System.out.println("Would you like to play again? (yes/no) ");
            String choice = scanner.nextLine();
            if(choice.equals("no")){
                weArePlaying = false;
            }
        }/*End of We Are Playing*/

        System.out.println("Game Over!");
    }

    public void print(char array[]){
        for(int i=0; i<array.length; i++){ // Assign empty dashes at start "_ _ _ _ _ _ _ _"
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public boolean isTheWordGuessed(char[] array){
        boolean condition = true;
        for(int i=0; i<array.length; i++){
            if(array[i] == '_'){
                condition = false;
            }
        }
        return condition;
    }
}
