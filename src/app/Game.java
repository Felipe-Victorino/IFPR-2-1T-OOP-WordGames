package app;

import games.CacaPalavras.WordSearch;
import games.Descoberta.WordShuffle;

public class Game {
    // TODO: Dificuldade ajustável: Permitir que o usuário escolha o nível de dificuldade, variando o tamanho do tabuleiro e o número de palavras escondidas.
    // TODO: Dicas progressivas: Permitir que o jogador peça mais dicas, como revelar uma letra adicional da palavra escondida.
    // TODO: Modo infinito: Gerar novos tabuleiros automaticamente após cada vitória, permitindo que o jogador continue jogando indefinidamente.
    // TODO: Listagem de palavras encontradas: Criar um placar que exibe todas as palavras encontradas pelo usuário até o momento

    private int score = 0;
    private static boolean hardMode;

    public void incrementScore(){
        this.score++;
    }
    public boolean getHardMode(){
        return hardMode;
    }
    public void setHardMode(boolean hardModeChoice) {
        hardMode = hardModeChoice;
    }

    public int getScore() {
        return score;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.gameLoop();

    }

    private void hardModeSwitch (){
        System.out.println("Turn HARDMODE on/off? (Y/n)");
        char choice = Helper.getUserInputChar();
        System.out.print("> ");
        switch (choice) {
            case 'y':
                setHardMode(!hardMode);
                break;
            case 'n':
                setHardMode(hardMode);
                break;

            default:
                break;
        }
    }

    public void gameLoop(){

        boolean loopState = true;

        while(loopState){

            this.printMenu();
            try {
                int choice = Integer.parseInt(Helper.getUserInputString());

                switch (choice){
                    case 0:
                        hardModeSwitch();
                        break;
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
        System.out.println("HARDMODE: " + getHardMode());
        System.out.println("======================");
        System.out.println("0 - Hardmode options");

        if (hardMode) {
            System.out.println("HAAAAAAAAAAAARDCORE!!!!!!");
        }

        System.out.println("Select game: ");
        System.out.println("1 - Word Search");
        System.out.println("2 - Word Shuffle");
        System.out.println("3 - Exit");
        System.out.println("======================");
        System.out.print("> ");

    }

}