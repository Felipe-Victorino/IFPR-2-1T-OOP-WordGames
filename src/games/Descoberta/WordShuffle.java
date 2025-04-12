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
        String wordShuffled2 = word.shuffleWord(word.wordChosenArray[1]);
        System.out.println(wordShuffled1);
        System.out.println(wordShuffled2);
        new Guess(word);
        score++;
    }
}