package games.Descoberta;
import app.Words;
import app.Guess;
public class WordShuffle {

    public int score;
    public WordShuffle(){
        this.startGame();
    }

    public void startGame(){
        Words word = new Words();
        String wordShuffled1 = word.shuffleWord(word.wordChosenArray[0]);
        System.out.println(wordShuffled1);
        new Guess(wordShuffled1);
        score++;
    }
}