package games.Descoberta;
import app.Words;
import app.Guess;

public class WordShuffle {


    public WordShuffle(){
        this.startGame();
    }

    public void startGame(){
        Words word = new Words();

        String wordShuffled1 = word.shuffleWord(word.wordChosenArray[0]);
        System.out.println(wordShuffled1);
        verifyGuess(word);
    }

    private void verifyGuess(Words word) {
        Guess guess = new Guess();
        while (true) {
            if ((guess.getUserGuess()).equals("tip")) {
                this.showHintWord(word);
            } else if (guess.getUserGuess().equals(word.wordChosenArray[0])) {
                System.out.println("CORRECT");
                break;
            } else {
                System.out.println("INCORRECT");
            }
            guess.setUserGuess(null);
        }
    }

    public void showHintWord(Words word) {
        System.out.printf("The first letter of one of the words is: %S%n", word.giveHint(0));
    }
}