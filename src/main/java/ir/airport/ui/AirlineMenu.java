package ir.airport.ui;

import ir.airport.entity.Airline;
import ir.airport.utility.Context;

import static ir.airport.ui.base.BaseMenu.number;
import static ir.airport.ui.base.BaseMenu.skeffolding;

public class AirlineMenu {

    public void airlinePage(Airline airline){
        skeffolding();
        System.out.println("1 -> Add Ticket");
        System.out.println("2 -> Edit Ticket");
        System.out.println("3 -> Remove Ticket");
        System.out.println("4 -> Logout");
        Integer select = number.nextInt();

        switch (select){
            case 1:
                addTicket(airline);
                break;
            case 2:
                editTicket(airline);
                break;
            case 3:
                removeTicket(airline);
                break;
            case 4:
                skeffolding();
                System.out.println("You were logged out!");
                Context.baseMenu.startMenu();
        }
    }

    public void addTicket(Airline airline){

    }

    public void editTicket(Airline airline){

    }

    public void removeTicket(Airline airline){

    }

}
