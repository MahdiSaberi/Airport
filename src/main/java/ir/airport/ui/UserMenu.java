package ir.airport.ui;

import ir.airport.utility.Context;

import static ir.airport.ui.base.BaseMenu.number;
import static ir.airport.ui.base.BaseMenu.skeffolding;

public class UserMenu {

    public void userPage(){
        skeffolding();
        System.out.println("1 -> See & Buy Tickets");
        System.out.println("2 -> Ticket Refund");
        System.out.println("3 -> Logout");
        Integer select = number.nextInt();
    }

    public void seeAndBuyTickets(){
        Context.ticketMenu.ticketList();
        skeffolding();
        System.out.println("1 -> Reserve by ID");
        System.out.println("2 -> Search");
        System.out.println("3 -> Sort");
        System.out.println("4 -> My Active Tickets");
        System.out.println("5 -> Back");
        Integer select = number.nextInt();
    }


}
