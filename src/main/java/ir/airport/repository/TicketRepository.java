package ir.airport.repository;

import ir.airport.base.repository.BaseRepository;
import ir.airport.entity.Ticket;

import java.util.List;

public interface TicketRepository extends BaseRepository<Ticket,Long> {
    List<Ticket> orderByPrice();
    List<Ticket> orderByOrigin();
    List<Ticket> orderByDestination();
    List<Ticket> orderByLabel();
}
