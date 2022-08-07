package ir.airport.service.impl;

import ir.airport.base.repository.impl.BaseRepositoryImpl;
import ir.airport.base.service.impl.BaseServiceImpl;
import ir.airport.entity.Ticket;
import ir.airport.repository.TicketRepository;
import ir.airport.service.TicketService;
import ir.airport.utility.Context;

import java.util.List;


public class TicketServiceImpl extends BaseServiceImpl<Ticket,Long, TicketRepository> implements TicketService {

    public TicketServiceImpl(TicketRepository repository) {
        super(repository);
    }

    @Override
    public List<Ticket> orderByPrice() {
        repository.beginTransaction();
        List<Ticket> tickets = repository.orderByPrice();
        repository.commitTransaction();
        return tickets;
    }

    @Override
    public List<Ticket> orderByOrigin() {
        repository.beginTransaction();
        List<Ticket> tickets = repository.orderByOrigin();
        repository.commitTransaction();
        return tickets;
    }

    @Override
    public List<Ticket> orderByDestination() {
        repository.beginTransaction();
        List<Ticket> tickets = repository.orderByDestination();
        repository.commitTransaction();
        return tickets;
    }

    @Override
    public List<Ticket> orderByLabel() {
        repository.beginTransaction();
        List<Ticket> tickets = repository.orderByLabel();
        repository.commitTransaction();
        return tickets;
    }
}
