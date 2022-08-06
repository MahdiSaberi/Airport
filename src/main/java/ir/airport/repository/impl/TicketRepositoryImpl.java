package ir.airport.repository.impl;

import ir.airport.base.repository.impl.BaseRepositoryImpl;
import ir.airport.entity.Airline;
import ir.airport.entity.Ticket;
import ir.airport.repository.TicketRepository;
import ir.airport.utility.Context;

public class TicketRepositoryImpl extends BaseRepositoryImpl<Ticket,Long> implements TicketRepository {

    @Override
    public Class<Ticket> getEntityClass() {return Ticket.class;}


    public void initAirlinesWithTickets(){
        Airline airline1 = new Airline("Mahan","321");
        Airline airline2 = new Airline("Zagros","4321");
        Airline airline3 = new Airline("Iran Air","54321");

        Context.airline.save(airline1);
        Context.airline.save(airline2);
        Context.airline.save(airline3);

        System.out.println("Airlines Initialized successfully!");

        Ticket ticket0 = new Ticket(airline1,"Tehran","Qazvin",150L);
        Ticket ticket1 = new Ticket(airline2,"Tehran","Isfahan",250L);
        Ticket ticket2 = new Ticket(airline1,"Kish","Mashhad",300L);
        Ticket ticket3 = new Ticket(airline3,"Abadan","Tehran",450L);
        Ticket ticket4 = new Ticket(airline3,"Mashhad","Tehran",900L);
        Ticket ticket5 = new Ticket(airline2,"Tabriz","Bushehr",780L);

        Context.ticket.save(ticket0);
        Context.ticket.save(ticket1);
        Context.ticket.save(ticket2);
        Context.ticket.save(ticket3);
        Context.ticket.save(ticket4);
        Context.ticket.save(ticket5);

        System.out.println("Tickets Initialized successfully!");
    }
}
