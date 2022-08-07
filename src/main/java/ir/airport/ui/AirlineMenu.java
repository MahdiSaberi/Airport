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
        System.out.println("1 -> "+airline.getLabel()+" Tickets");
        System.out.println("2 -> Add Ticket");
        System.out.println("3 -> Remove Ticket");
        System.out.println("4 -> Logout");
        Integer select = number.nextInt();

        System.out.println("select:"+select);
        switch (select){
            case 1:
                labelTickets(airline);
                break;
            case 2:
                addTicket(airline);
                break;
            case 3:
                removeTicket(airline);
                break;
            case 4:
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
        airlinePage(airline);
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
        scaffolding();
        System.out.println("Select Ticket to delete:");
        Long id = number.nextLong();
        Context.ticket.delete(id);
        System.out.println("Deleted successfully!");
        airlinePage(airline);
    }

}
