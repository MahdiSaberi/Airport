package ir.airport.repository.impl;

import ir.airport.base.repository.BaseRepository;
import ir.airport.base.repository.impl.BaseRepositoryImpl;
import ir.airport.entity.Airline;
import ir.airport.entity.User;
import ir.airport.repository.AirlineRepository;
import ir.airport.utility.Context;

public class AirlineRepositoryImpl extends BaseRepositoryImpl<Airline,Long> implements AirlineRepository {

    @Override
    public Class<Airline> getEntityClass() {
        return Airline.class;
    }

    @Override
    public Airline findByLabel(String label) {
        return entityManager.createQuery("from Airline"+" where label =: label",Airline.class).
                setParameter("label",label).getSingleResult();
    }
}
