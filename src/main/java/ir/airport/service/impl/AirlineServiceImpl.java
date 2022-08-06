package ir.airport.service.impl;

import ir.airport.base.service.BaseService;
import ir.airport.base.service.impl.BaseServiceImpl;
import ir.airport.entity.Airline;
import ir.airport.repository.AirlineRepository;
import ir.airport.service.AirlineService;

public class AirlineServiceImpl extends BaseServiceImpl<Airline,Long, AirlineRepository> implements AirlineService {

    public AirlineServiceImpl(AirlineRepository repository) {
        super(repository);
    }
}
