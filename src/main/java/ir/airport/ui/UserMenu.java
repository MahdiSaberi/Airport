package ir.airport.ui;

import ir.airport.entity.Ticket;
import ir.airport.entity.User;
import ir.airport.utility.Context;
import static ir.airport.base.ui.BaseMenu.number;
import static ir.airport.base.ui.BaseMenu.scaffolding;

public class UserMenu {

    public void userPage(User user){
        scaffolding();
        System.out.println("1 -> See & Buy Tickets");
        System.out.println("2 -> Ticket Refund");
        System.out.println("3 -> Active Tickets");
        System.out.println("4 -> Logout");
        Integer select = number.nextInt();

        switch (select){
            case 1:
                Context.ticketMenu.ticketList("ID");
                seeAndBuyTickets(user);
                break;
            case 2:
                ticketRefund(user);
                break;
            case 3:
                activeTickets(user);
                break;
            case 4:
                System.out.println("You were logged out!");
                Context.first.startMenu();

        }
    }

    public void seeAndBuyTickets(User user){
        scaffolding();
        System.out.println("1 -> Reserve");
        System.out.println("2 -> Search");
        System.out.println("3 -> Sort");
        System.out.println("4 -> Back");

        Integer select = number.nextInt();

        switch (select){
            case 1:
                Context.ticketMenu.reserve(user);
                break;
            case 2:
                Context.ticketMenu.searching();
                break;
            case 3:
                Context.ticketMenu.sorting(user);
                seeAndBuyTickets(user);
                break;
            case 4:
                userPage(user);
        }
    }

    public void ticketRefund(User user){
        Context.ticketMenu.ticketsUniqueByUser(user);
        scaffolding();
        System.out.println("Select Ticket by ID:");
        Long id = number.nextLong();
        Ticket ticket = Context.ticket.findById(id);

        if(ticket.getUsers().contains(user)){
            ticket.setReservedNumber(ticket.getReservedNumber()-1);
            ticket.getUsers().remove(user);
            Context.ticket.update(ticket);

            System.out.println("Refunded!");
            userPage(user);
        }

        else{
            System.out.println("Please Enter valid ID.");
            ticketRefund(user);
        }

    }

    public void activeTickets(User user){
        Context.ticketMenu.ticketsUniqueByUser(user);
    }
}