package app;

import games.CacaPalavras.WordSearch;
import games.Descoberta.WordShuffle;

public class Game {

    static int score = 0;

    public static void main(String[] args) {

        Game.gameLoop();

    }
    public static void gameLoop(){

        Helper sc = new Helper();
        boolean loopState = true;

        while(loopState){

            Game.printMenu();

            int choice = Integer.parseInt(sc.getUserInputString());

            switch (choice){
                case 1:
                    WordSearch search = new WordSearch();
                    score += search.score;
                    break;
                case 2:
                    WordShuffle shuffle = new WordShuffle();
                    score += shuffle.score;
                    break;
                case 3:
                    loopState = false;
                    break;
                default:
                    break;
            }
        }
    }
    public static void printMenu(){

        System.out.println("======================");
        System.out.printf("Score: %d%n", score);
        System.out.println("======================");
        System.out.println("Select game: ");
        System.out.println("1 - Word Search");
        System.out.println("2 - Word Shuffle");
        System.out.println("3 - Exit");
        System.out.println("======================");
        System.out.print("> ");

    }
}