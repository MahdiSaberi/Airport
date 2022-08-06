package ir.airport.utility;

import ir.airport.service.AirlineService;
import ir.airport.service.TicketService;
import ir.airport.service.UserService;
import ir.airport.service.impl.UserServiceImpl;
import jakarta.persistence.EntityManager;

public class Context {
    public static EntityManager entityManager = HibernateUtil.getEntityManager();

    public static UserService user = new UserServiceImpl();

    public static AirlineService airline;

    public static TicketService ticket;


}
