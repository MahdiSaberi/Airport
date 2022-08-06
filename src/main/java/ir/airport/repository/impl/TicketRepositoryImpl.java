package ir.airport.repository.impl;

import ir.airport.base.repository.impl.BaseRepositoryImpl;
import ir.airport.entity.Ticket;
import ir.airport.repository.TicketRepository;

public class TicketRepositoryImpl extends BaseRepositoryImpl<Ticket,Long> implements TicketRepository {

    @Override
    public Class<Ticket> getEntityClass() {return Ticket.class;}
}
