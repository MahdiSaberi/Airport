package ir.airport.ui.base;

import ir.airport.ui.Login;
import ir.airport.ui.Register;
import ir.airport.ui.TicketMenu;
import ir.airport.ui.UserMenu;
import ir.airport.utility.Context;

import java.util.Scanner;

public class BaseMenu {
    public static Scanner string = new Scanner(System.in);
    public static Scanner number = new Scanner(System.in);

    public static void scaffolding(){
        System.out.println("=====================");
    }

    public void startMenu(){
        scaffolding();
        System.out.println("Welcome!");
        scaffolding();
        System.out.println("1 -> Login");
        System.out.println("2 -> Register");
        System.out.println("3 -> Exit");
        Integer select = number.nextInt();

        switch (select){
            case 1:
                Context.login.loginMenu();
                break;
            case 2:
                Context.register.registerMenu();
                break;
            case 3:
                System.exit(0);
        }
    }

}
