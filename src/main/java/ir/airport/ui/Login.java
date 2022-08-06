package ir.airport.ui;

import static ir.airport.ui.BaseMenu.*;

public class Login {

    public void loginMenu(){
        skeffolding();
        System.out.println("Login as:");
        skeffolding();
        System.out.println("1 -> User");
        System.out.println("2 -> Airline");
        Integer select = number.nextInt();

    }

    public void userLogin(){
        skeffolding();
        System.out.println("Username:");
        String username = string.nextLine();
        System.out.println("Password:");
        String password = string.nextLine();
    }

    public void airlineLogin(){
        skeffolding();
        System.out.println("Label:");
        String label = string.nextLine();
        System.out.println("Password:");
        String password = string.nextLine();
    }
}
