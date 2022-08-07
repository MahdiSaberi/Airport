package ir.airport.service;

import ir.airport.base.service.BaseService;
import ir.airport.entity.Ticket;

import java.util.List;

public interface TicketService extends BaseService<Ticket,Long> {
    List<Ticket> orderByPrice();
    List<Ticket> orderByOrigin();
    List<Ticket> orderByDestination();
    List<Ticket> orderByLabel();
}
