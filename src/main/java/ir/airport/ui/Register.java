package ir.airport.ui;

import ir.airport.entity.User;
import ir.airport.utility.Context;

import static ir.airport.ui.base.BaseMenu.*;

public class Register {

    public void registerMenu(){
        scaffolding();
        System.out.println("Register as:");
        scaffolding();
        System.out.println("1 -> User");
        System.out.println("2 -> Airline");
        Integer select = number.nextInt();

    }

    public void registerUser(){
        System.out.println("First Name:");
        String firstName = string.nextLine();
        System.out.println("Last Name:");
        String lastName = string.nextLine();
        System.out.println("Username:");
        String username = string.nextLine();
        System.out.println("Password:");
        String password = string.nextLine();

        try{
            User user = new User(firstName,lastName,username,password);
            Context.user.save(user);
            scaffolding();
            System.out.println("You Registered!");
        }catch (Exception e){
            e.printStackTrace();
            scaffolding();
            System.out.println("This username already reserved.");
        }finally {
            Context.baseMenu.startMenu();
        }
    }

    public void registerAirline(){
        System.out.println("Label:");
        String label = string.nextLine();
        System.out.println("Password:");
        String password = string.nextLine();
    }
}
