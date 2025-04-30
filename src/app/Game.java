package app;

import games.CacaPalavras.WordSearch;
import games.Descoberta.WordShuffle;

public class Game {

    private int score = 0;
    static int choice;

    public void incrementScore(){
        this.score++;
    }

    public int getScore() {
        return score;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.gameLoop();

    }

    public void gameLoop(){

        boolean loopState = true;

        while(loopState){

            this.printMenu();
            try {
                choice = Integer.parseInt(Helper.getUserInputString());
                switch (choice){
                    case 1:
                        new WordSearch();
                        this.incrementScore();
                        break;
                    case 2:
                        new WordShuffle();
                        this.incrementScore();
                        break;
                    case 3:
                        loopState = false;
                        break;
                    default:
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Whatever you typed isn't a number, try again");
            }

        }
    }

    public void printMenu(){
        System.out.println("======================");
        System.out.printf("|| Score: %d ||%n", this.getScore());
        System.out.println("======================");
        System.out.println("Select game: ");
        System.out.println("1 - Word Search");
        System.out.println("2 - Word Shuffle");
        System.out.println("3 - Exit");
        System.out.println("======================");
        System.out.print("> ");

    }
}