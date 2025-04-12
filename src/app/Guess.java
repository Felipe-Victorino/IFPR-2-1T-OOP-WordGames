package app;
import java.util.Objects;

public class Guess {
    static Helper help = new Helper();
    String userGuess;
    private String alreadyGuessed;
    private int correctGuess = 0;

    public Guess(Words word){
        boolean guessValidity = false;
        while (!guessValidity) {
            String guess = this.UserGuess(this);
            guessValidity = this.verifyGuess(word, guess);
        }
    }


    public String UserGuess(Guess guess) {

        System.out.print("Insert your guess: ");
        return guess.userGuess = help.getUserInputString();

    }

    public boolean verifyGuess(Words word, String guess) {

            if (guess.equals("tip")) {
                this.showHint(word);
                return false;
            } else if (Objects.equals(alreadyGuessed, guess)) {
                System.out.println("ALREADY GUESSED");
                return false;
            } else if (Objects.equals(guess, word.wordChosenArray[0]) || Objects.equals(guess, word.wordChosenArray[1])) {
                System.out.println("CORRECT");
                alreadyGuessed = guess;
                correctGuess++;
                return correctGuess == 2;
            } else {
                System.out.println("INCORRECT");
                return false;
            }

    }
    public void showHint(Words word){
        System.out.printf("The first letter of one of the words is: %S%n", word.giveHint(help.getRandomNumber(0,1)));
    }
}