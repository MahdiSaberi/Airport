package ir.airport.repository;

import ir.airport.base.repository.BaseRepository;
import ir.airport.entity.Airline;

public interface AirlineRepository extends BaseRepository<Airline,Long> {

    Airline findByLabel(String label);
}
