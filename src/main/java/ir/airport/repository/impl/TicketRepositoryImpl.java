package ir.airport.repository.impl;

import ir.airport.base.repository.impl.BaseRepositoryImpl;
import ir.airport.entity.Airline;
import ir.airport.entity.Ticket;
import ir.airport.repository.TicketRepository;
import ir.airport.repository.impl.enumeration.Sort;
import ir.airport.utility.Context;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class TicketRepositoryImpl extends BaseRepositoryImpl<Ticket,Long> implements TicketRepository {

    @Override
    public Class<Ticket> getEntityClass() {return Ticket.class;}

    @Override
    public List<Ticket> orderBy(String order, Sort type){

        if(order.equals("label")){
            if(type == Sort.ASC)
                return entityManager.createQuery("from Ticket order by airline.label asc ",Ticket.class).getResultList();

            else
                return entityManager.createQuery("from Ticket order by airline.label desc ",Ticket.class).getResultList();
        }

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ticket> criteriaQuery = criteriaBuilder.createQuery(Ticket.class);
        Root<Ticket> root = criteriaQuery.from(Ticket.class);

        if(type == Sort.ASC)
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(order)));

        else if(type == Sort.DESC)
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get(order)));

        CriteriaQuery<Ticket> select = criteriaQuery.select(root);
        TypedQuery<Ticket> query = entityManager.createQuery(select);
        List<Ticket> tickets = query.getResultList();

        return tickets;
    }

    public void initAirlinesWithTickets(){
        Airline airline1 = new Airline("Mahan","321");
        Airline airline2 = new Airline("Zagros","4321");
        Airline airline3 = new Airline("Iran Air","54321");

        Context.airline.save(airline1);
        Context.airline.save(airline2);
        Context.airline.save(airline3);

        System.out.println("Airlines Initialized successfully!");

        Ticket ticket0 = new Ticket(airline1,"Tehran","Qazvin",900L);
        Ticket ticket1 = new Ticket(airline2,"Tehran","Isfahan",400L);
        Ticket ticket2 = new Ticket(airline1,"Kish","Mashhad",300L);
        Ticket ticket3 = new Ticket(airline3,"Abadan","Tehran",250L);
        Ticket ticket4 = new Ticket(airline3,"Mashhad","Tehran",150L);
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
