package ir.airport.ui;

import ir.airport.entity.Airline;
import ir.airport.entity.User;
import ir.airport.utility.Context;

import static ir.airport.ui.base.BaseMenu.*;

public class Login {

    public void loginMenu(){
        scaffolding();
        System.out.println("Login as:");
        scaffolding();
        System.out.println("1 -> User");
        System.out.println("2 -> Airline");
        Integer select = number.nextInt();

        switch (select){
            case 1:
                userLogin();
                break;
            case 2:
                airlineLogin();
                break;
        }

    }

    public void userLogin(){
        scaffolding();
        System.out.println("Username:");
        String username = string.nextLine();
        System.out.println("Password:");
        String password = string.nextLine();
        User user = Context.user.findByUsername(username);
        if(user != null && user.getPassword().equals(password)) {
            scaffolding();
            System.out.println("Login was successfully!");
            Context.userMenu.userPage(user);
        }

        else {
            scaffolding();
            System.out.println("Wrong informations");
            userLogin();
        }
    }

    public void airlineLogin(){
        scaffolding();
        System.out.println("Label:");
        String label = string.nextLine();
        System.out.println("Password:");
        String password = string.nextLine();

        Airline airline = Context.airline.findByLabel(label);

        if(airline != null && airline.getPassword().equals(password)) {
            scaffolding();
            System.out.println("Login was successfully!");
            Context.airlineMenu.airlinePage(airline);
        }

        else {
            scaffolding();
            System.out.println("Wrong informations");
            airlineLogin();
        }
    }
}
