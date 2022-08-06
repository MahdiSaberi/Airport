package ir.airport.repository.impl;

import ir.airport.base.repository.BaseRepository;
import ir.airport.base.repository.impl.BaseRepositoryImpl;
import ir.airport.entity.Airline;
import ir.airport.repository.AirlineRepository;

public class AirlineRepositoryImpl extends BaseRepositoryImpl<Airline,Long> implements AirlineRepository {

    @Override
    public Class<Airline> getEntityClass() {
        return Airline.class;
    }
}
