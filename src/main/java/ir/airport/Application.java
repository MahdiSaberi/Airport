package ir.airport;

import ir.airport.entity.User;
import ir.airport.repository.UserRepository;
import ir.airport.repository.impl.TicketRepositoryImpl;
import ir.airport.repository.impl.UserRepositoryImpl;
import ir.airport.ui.Register;
import ir.airport.utility.Context;
import ir.airport.utility.HibernateUtil;

public class Application {
    public static void main(String[] args) {
        HibernateUtil.getEntityManager();
        //Context.baseMenu.startMenu();
        //init();
        //Register.registerUser();
        System.out.println("Done!");
    }

    public static void init(){
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        userRepository.initUsers();

        TicketRepositoryImpl ticketRepository = new TicketRepositoryImpl();
        ticketRepository.initAirlinesWithTickets();
    }
}
