package games.CacaPalavras;

import app.Words;
import app.Guess;
public class WordSearch {

    public int score;
    public WordSearch(){
        this.gameStart();
    }

    public void gameStart(){

        Field field = new Field();
        field.fillFieldWithNoise(field);
        Words word = new Words(field);
        new Guess(word);
        score++;
    }


}