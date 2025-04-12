package app;

import java.util.Scanner;
import java.util.Random;

public class Helper {
    Random rd = new Random();
    Scanner sc = new Scanner(System.in);

    public String getUserInputString(){
        return sc.nextLine();
    }

    public int getRandomNumber(int numa, int numb){
        return rd.nextInt(numa, numb);
    }
}