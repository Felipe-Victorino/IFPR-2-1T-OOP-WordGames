package app;

import java.util.Scanner;
import java.util.Random;

public class Helper {
    static Random rd = new Random();
    static Scanner sc = new Scanner(System.in);

    public static String getUserInputString(){
        return sc.nextLine();
    }

    public static int getRandomNumber(int numa, int numb){
        return rd.nextInt(numa, numb);
    }
}