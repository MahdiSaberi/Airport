package ir.airport.service.impl;

import ir.airport.base.repository.impl.BaseRepositoryImpl;
import ir.airport.base.service.impl.BaseServiceImpl;
import ir.airport.entity.Ticket;
import ir.airport.repository.TicketRepository;
import ir.airport.repository.impl.enumeration.Sort;
import ir.airport.service.TicketService;
import ir.airport.utility.Context;

import java.util.List;


public class TicketServiceImpl extends BaseServiceImpl<Ticket,Long, TicketRepository> implements TicketService {

    public TicketServiceImpl(TicketRepository repository) {
        super(repository);
    }

    @Override
    public List<Ticket> orderBy(String order, Sort type) {
        repository.beginTransaction();
        List<Ticket> tickets = repository.orderBy(order,type);
        repository.commitTransaction();
            return tickets;
    }
}
