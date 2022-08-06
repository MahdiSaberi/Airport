package ir.airport.ui;

import static ir.airport.ui.BaseMenu.number;
import static ir.airport.ui.BaseMenu.skeffolding;

public class Register {

    public void registerMenu(){
        skeffolding();
        System.out.println("Register as:");
        skeffolding();
        System.out.println("1 -> User");
        System.out.println("2 -> Airline");
        Integer select = number.nextInt();
    }
}
