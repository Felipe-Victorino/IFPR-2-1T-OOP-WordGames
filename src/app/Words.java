package app;
import games.CacaPalavras.Field;

import java.util.Objects;

public class Words {

    private final String[] totalWordArray = {
            "perigee",
            "apogee",
            "xylophone",
            "aero-static",
            "entropy",
            "radiophone",
            "portal",
            "diskette",
            "operator",
            "magnetic",
            "scalpel",
            "oregano",
            "rosemary"
    };

    public String[] wordChosenArray = {
            totalWordArray[Helper.getRandomNumber(0, totalWordArray.length)],
            totalWordArray[Helper.getRandomNumber(0, totalWordArray.length)]
    };

    private int lastLineUsed;

    public Words(){

    }

    public Words(Field field){
        this.addWordToField(field, wordChosenArray[0]);
        this.addWordToField(field, wordChosenArray[1]);
        field.printField(field);

    }

    public String shuffleWord(String wordChosen){
        char[] chosenArray = wordChosen.toCharArray();

        for (int i = 0; i < chosenArray.length; i++) {
            int randomIndex = Helper.getRandomNumber(0, chosenArray.length);
            char aux = chosenArray[i];
            chosenArray[i] = chosenArray[randomIndex];
            chosenArray[randomIndex] = aux;
        }

        return new String(chosenArray);
    }


    private void addWordToField(Field board, String wordChosen){
        int xLocation = Helper.getRandomNumber(0, board.getSize());
        int yLocation = Helper.getRandomNumber(0, board.getSize() - wordChosen.length());

        if (Objects.equals(wordChosenArray[0], wordChosenArray[1])){
            wordChosenArray[0] = totalWordArray[Helper.getRandomNumber(0, totalWordArray.length)];
        }
        if (xLocation == lastLineUsed) {xLocation++;}

        char[][] tempBoard = board.getBoard();

        try {
            for (int i = 0; i < wordChosen.length(); i++) {
                tempBoard[xLocation][yLocation + i] = wordChosen.charAt(i);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            xLocation = Helper.getRandomNumber(0, board.getSize());
        } finally {
            board.setBoard(tempBoard);
            this.lastLineUsed = xLocation;
        }
    }

    public char giveHint(int index){
        return wordChosenArray[index].charAt(0);
    }
}