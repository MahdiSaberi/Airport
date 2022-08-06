package ir.airport.service.impl;

import ir.airport.base.repository.impl.BaseRepositoryImpl;
import ir.airport.base.service.impl.BaseServiceImpl;
import ir.airport.entity.Ticket;
import ir.airport.repository.TicketRepository;
import ir.airport.service.TicketService;

public class TicketServiceImpl extends BaseServiceImpl<Ticket,Long, TicketRepository> implements TicketService {
    public TicketServiceImpl(TicketRepository repository) {
        super(repository);
    }
}
