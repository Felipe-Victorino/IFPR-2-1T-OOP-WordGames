package app;
import games.CacaPalavras.Field;

import java.util.Objects;

public class Words {
    Helper help = new Helper();

    public Words(){

    }
    public Words(Field field){
        this.addWordToField(field, wordChosenArray[0]);
        this.addWordToField(field, wordChosenArray[1]);
        field.printField(field);

    }
    private final String[] totalWordArray = {
            "AAAAAAAAAA",
            "perigee",
            "apogee",
            "xylophone",
            "aerostatic",
            "entropy",
            "radiophone",
            "portal",
            "diskette",
            "operator",
            "magnetic"
    };

    public String wordChosen = totalWordArray[help.getRandomNumber(0, totalWordArray.length)];
    String wordChosen2 = totalWordArray[help.getRandomNumber(0, totalWordArray.length)];

    public String[] wordChosenArray = {wordChosen, wordChosen2};

    private int lastLineUsed;

    public String shuffleWord(String wordChosen){
        char[] chosenArray = wordChosen.toCharArray();

        for (int i = 0; i < chosenArray.length; i++) {
            int randomIndex = help.getRandomNumber(0, chosenArray.length);
            char aux = chosenArray[i];
            chosenArray[i] = chosenArray[randomIndex];
            chosenArray[randomIndex] = aux;
        }

        return new String(chosenArray);
    }


    private void addWordToField(Field board, String wordChosen){
        int xLocation = help.getRandomNumber(0, board.size);
        int yLocation = help.getRandomNumber(0, board.size - wordChosen.length()) ;

        if (Objects.equals(wordChosenArray[0], wordChosenArray[1])){
            wordChosenArray[0] = totalWordArray[help.getRandomNumber(0, totalWordArray.length)];
        }
        if (xLocation++ >= board.size) {xLocation = 0;}
        if (xLocation == lastLineUsed) {xLocation++;}


        for (int i = 0; i < wordChosen.length(); i++) {
            board.board[xLocation][yLocation + i] = wordChosen.charAt(i);
        }

        this.lastLineUsed = xLocation;
    }

    public char giveHint(int index){
        return wordChosenArray[index].charAt(0);
    }
}