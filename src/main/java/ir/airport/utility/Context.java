package ir.airport.utility;

import ir.airport.entity.Airline;
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
import ir.airport.ui.*;
import ir.airport.ui.base.BaseMenu;
import jakarta.persistence.EntityManager;

public class Context {
    public static EntityManager entityManager = HibernateUtil.getEntityManager();

    public static UserService user = new UserServiceImpl(getUserRepository());
    public static AirlineService airline = new AirlineServiceImpl(getAirlineRepository());
    public static TicketService ticket = new TicketServiceImpl(getTicketRepository());

    //menu
    //public static BaseMenu baseMenu = new BaseMenu();
    public static First first = new First();
    public static Login login = new Login();
    public static Register register = new Register();
    public static TicketMenu ticketMenu = new TicketMenu();
    public static UserMenu userMenu = new UserMenu();
    public static AirlineMenu airlineMenu = new AirlineMenu();

    private static UserRepository getUserRepository(){
        return new UserRepositoryImpl();
    }

    private static TicketRepository getTicketRepository(){
        return new TicketRepositoryImpl();
    }

    private static AirlineRepository getAirlineRepository(){
        return new AirlineRepositoryImpl();
    }

    public static First getFirst() {return first;}

    public static Login getLogin() {
        return new Login();
    }

    public static Register getRegister() {
        return new Register();
    }

    public static TicketMenu getTicketMenu() {
        return new TicketMenu();
    }

    public static UserMenu getUserMenu() {
        return userMenu;
    }
}
