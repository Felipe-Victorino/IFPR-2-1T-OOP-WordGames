package app;

public class Guess {

    private String userGuess;

    public Guess(){
        setUserGuess(promptUserGuess());
    }

    private String promptUserGuess() {
        System.out.print("Insert your guess: ");
        return this.userGuess = Helper.getUserInputString();

    }

    public String getUserGuess() {
        return userGuess;
    }

    public void setUserGuess(String userGuess) {
        this.userGuess = userGuess;
    }
}