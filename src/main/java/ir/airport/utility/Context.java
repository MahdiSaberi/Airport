package ir.airport.utility;

import ir.airport.repository.AirlineRepository;
import ir.airport.repository.TicketRepository;
import ir.airport.repository.UserRepository;
import ir.airport.repository.impl.AirlineRepositoryImpl;
import ir.airport.repository.impl.TicketRepositoryImpl;
import ir.airport.repository.impl.UserRepositoryImpl;
import ir.airport.service.AirlineService;
import ir.airport.service.TicketService;
import ir.airport.service.UserService;
import ir.airport.service.impl.AirlineServiceImpl;
import ir.airport.service.impl.TicketServiceImpl;
import ir.airport.service.impl.UserServiceImpl;
import jakarta.persistence.EntityManager;

public class Context {
    public static EntityManager entityManager = HibernateUtil.getEntityManager();

    public static UserService user = new UserServiceImpl(getUserRepository());

    public static AirlineService airline = new AirlineServiceImpl(getAirlineRepository());

    public static TicketService ticket = new TicketServiceImpl(getTicketRepository());

    private static UserRepository getUserRepository(){
        return new UserRepositoryImpl();
    }

    private static TicketRepository getTicketRepository(){
        return new TicketRepositoryImpl();
    }

    private static AirlineRepository getAirlineRepository(){
        return new AirlineRepositoryImpl();
    }

}
