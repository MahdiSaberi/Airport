package ir.airport.ui;
import ir.airport.entity.Ticket;
import ir.airport.utility.Context;

import java.util.List;

import static ir.airport.ui.base.BaseMenu.number;
import static ir.airport.ui.base.BaseMenu.skeffolding;

public class TicketMenu {

    public void ticketList(){
        List<Ticket> tickets = Context.ticket.findAll();

        tickets.forEach(ticket -> {
            skeffolding();
            System.out.println("Label: "+ticket.getAirline().getLabel());
            System.out.println("Origin: "+ticket.getOrigin()+"\t"+"Destination: "+ticket.getDestination()+"\t"+"Price: "+ticket.getPrice());
        });
    }
}
