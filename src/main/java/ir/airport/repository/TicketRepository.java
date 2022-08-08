package ir.airport.repository;

import ir.airport.base.repository.BaseRepository;
import ir.airport.entity.Ticket;
import ir.airport.repository.impl.enumeration.Sort;

import java.util.List;

public interface TicketRepository extends BaseRepository<Ticket,Long> {
    List<Ticket> orderBy(String order, Sort sort);
    List<Ticket> orderByLabel();
}
