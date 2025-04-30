package games.CacaPalavras;

import app.Helper;
import app.Words;
import app.Guess;

public class WordSearch {

    public int score;
    private String alreadyGuessed;
    private int correctGuess = 0;

    public WordSearch(){
        this.gameStart();
    }

    public void incCorrectGuess(){
        correctGuess++;
    }

    public void gameStart(){
        Field field = new Field();
        field.fillFieldWithNoise(field);
        Words word = new Words(field);
        verifyGuess(word);
        score++;
    }

    public void verifyGuess(Words word) {

        while (true) {
            Guess guess = new Guess();
            if ((guess.getUserGuess()).equals("tip")) {
                this.showHintField(word);

            } else if ((guess.getUserGuess()).equals(alreadyGuessed)) {
                System.out.println("ALREADY GUESSED");

            } else if ((guess.getUserGuess()).equals(word.wordChosenArray[0]) || (guess.getUserGuess()).equals(word.wordChosenArray[1])) {
                System.out.println("CORRECT");
                alreadyGuessed = guess.getUserGuess();
                incCorrectGuess();
                if (correctGuess == 2) {
                    break;
                }
            } else {
                System.out.println("INCORRECT");

            }
        }
    }

    public void showHintField(Words word){
        System.out.printf("The first letter of one of the words is: %S%n", word.giveHint(new Helper().getRandomNumber(0,1)));
    }


}