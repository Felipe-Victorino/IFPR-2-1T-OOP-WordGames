package app;
import games.CacaPalavras.Field;

public class Words {

    private final String[] easyWordArray = {
            "bread",
            "violin",
            "piglet",
            "trumpet",
            "chalk",
            "zebra",
            "giraffe",
            "elephant",
            "flower",
            "xzyzy",
            "sesame",
            "windy"
    };

    private final String[] hardWordArray = {
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
            "rosemary",
            "usb",
            "hdmi"
    };

    public String[] wordChosenArray = new String[2];

    private int lastLineUsed;

    public Words(){

    }

    public Words(Field field){
        this.hardModeSetArray(new Game().getHardMode());
        this.addWordToField(field, wordChosenArray[0]);
        this.addWordToField(field, wordChosenArray[1]);
        field.printField(field);

    }

    public void hardModeSetArray(boolean isHardModeOn){
        if (isHardModeOn) {
            wordChosenArray[0] = hardWordArray[Helper.getRandomNumber(0, hardWordArray.length)];
            wordChosenArray[1] = hardWordArray[Helper.getRandomNumber(0, hardWordArray.length)];
        } else {
            wordChosenArray[0] = easyWordArray[Helper.getRandomNumber(0, hardWordArray.length)];
            wordChosenArray[1] = easyWordArray[Helper.getRandomNumber(0, hardWordArray.length)];
        }
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