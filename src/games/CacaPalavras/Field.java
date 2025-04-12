package games.CacaPalavras;
import app.Helper;
public class Field {

    Helper help = new Helper();
    public int size = 15;
    public char[][] board = new char[size][size];

    public void fillFieldWithNoise(Field board){
        System.out.println("Generating Field...");
        for (int x = 0; x < board.size; x++) {
            for (int y = 0; y < board.size; y++) {
                board.board[x][y] = (char) ('a' + help.getRandomNumber(0,25));
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