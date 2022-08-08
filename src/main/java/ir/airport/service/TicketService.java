package ir.airport.service;

import ir.airport.base.service.BaseService;
import ir.airport.entity.Ticket;
import ir.airport.repository.impl.enumeration.Sort;

import java.util.List;

public interface TicketService extends BaseService<Ticket,Long> {
    List<Ticket> orderBy(String order, Sort sort);
}
