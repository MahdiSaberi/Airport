package ir.airport.ui;
import ir.airport.base.ui.BaseMenu;
import ir.airport.utility.Context;


public class First extends BaseMenu {
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
