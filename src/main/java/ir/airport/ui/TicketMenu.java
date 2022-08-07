package ir.airport.ui;
import ir.airport.entity.Ticket;
import ir.airport.entity.User;
import ir.airport.utility.Context;

import java.util.List;
import java.util.stream.Collectors;

import static ir.airport.ui.base.BaseMenu.number;
import static ir.airport.ui.base.BaseMenu.scaffolding;

public class TicketMenu {

    public void ticketList(){
        List<Ticket> tickets = Context.ticket.findAll();

        tickets.forEach(ticket -> {
            scaffolding();
            System.out.println(ticket.getId()+". Label: "+ticket.getAirline().getLabel());
            System.out.println("Origin: "+ticket.getOrigin()+"\t"+"Destination: "+ticket.getDestination()+"\t"+"Price: "+ticket.getPrice());
        });
    }

    public void ticketsUniqueByUser(User user){
        List<Ticket> tickets = Context.ticket.findAll();
        tickets = tickets.stream().filter(ticket -> ticket.getUsers().contains(user)).collect(Collectors.toList());

        for(Ticket ticket : tickets){
            scaffolding();
            System.out.println(ticket.getId()+". Label: "+ticket.getAirline().getLabel());
            System.out.println("Origin: "+ticket.getOrigin()+"\t"+"Destination: "+ticket.getDestination()+"\t"+"Price: "+ticket.getPrice());
        }
    }
}
