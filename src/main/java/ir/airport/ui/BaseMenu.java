package ir.airport.ui;

import java.util.Scanner;

public class BaseMenu {
    public static Scanner string = new Scanner(System.in);
    public static Scanner number = new Scanner(System.in);

    public static String skeffolding(){
        return "=====================";
    }

    public void startMenu(){
        skeffolding();
        System.out.println("Welcome!");
        System.out.println("1 -> Login");
        System.out.println("2 -> Register");
        System.out.println("3 -> Exit");
        Integer select = number.nextInt();
    }

}
