package ir.airport.ui;

import ir.airport.entity.Airline;
import ir.airport.entity.Ticket;
import ir.airport.utility.Context;

import java.util.List;
import java.util.stream.Collectors;

import static ir.airport.ui.base.BaseMenu.*;

public class AirlineMenu {

    public void airlinePage(Airline airline){
        scaffolding();
        System.out.println("0 -> "+airline.getLabel()+" Tickets");
        System.out.println("1 -> Add Ticket");
        System.out.println("2 -> Remove Ticket");
        System.out.println("3 -> Logout");
        Integer select = number.nextInt();

        switch (select){
            case 0:
                labelTickets(airline);
                break;
            case 1:
                addTicket(airline);
                break;
            case 2:
                removeTicket(airline);
                break;
            case 3:
                scaffolding();
                System.out.println("You were logged out!");
                Context.first.startMenu();
        }
    }

    public void labelTickets(Airline airline){
        List<Ticket> tickets = Context.ticket.findAll();
        tickets = tickets.stream().filter(t -> t.getAirline().getLabel().equals(airline.getLabel())).collect(Collectors.toList());

        for(Ticket ticket : tickets){
            scaffolding();
            System.out.println(ticket.getId()+". Label: "+ticket.getAirline().getLabel());
            System.out.println("Origin: "+ticket.getOrigin()+"\t"+"Destination: "+ticket.getDestination()+"\t"+"Price: "+ticket.getPrice());
        }
    }

    public void addTicket(Airline airline){
        scaffolding();

        System.out.println("Origin");
        String origin = string.nextLine();

        System.out.println("Destination:");
        String destination = string.nextLine();

        System.out.println("Price:");
        Long price = number.nextLong();

        Ticket ticket = new Ticket(airline,origin,destination,price);

        Context.ticket.save(ticket);
        scaffolding();
        System.out.println("Ticket Added!");
        airlinePage(airline);

    }

    public void removeTicket(Airline airline){
        labelTickets(airline);
        scaffolding();
        System.out.println("Select Ticket to delete:");
        Long id = number.nextLong();
        Context.ticket.delete(id);
        System.out.println("Deleted successfully!");
        airlinePage(airline);
    }

}
