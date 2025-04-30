package games.CacaPalavras;
import static app.Helper.getRandomNumber;

public class Field {

    private final int size = 15;
    private char[][] board = new char[size][size];

    public int getSize() {
        return size;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public void fillFieldWithNoise(Field board){
        System.out.println("Generating Field...");
        for (int x = 0; x < board.size; x++) {
            for (int y = 0; y < board.size; y++) {
                board.board[x][y] = (char) ('a' + getRandomNumber(0,25));
            }
        }
    }

    public void printField(Field board){
        for (int x = 0; x < board.size; x++) {
            for (int y = 0; y < board.size; y++) {
                System.out.print("[" + board.board[x][y]+ "] ");
            }
            System.out.println();
        }
    }

}