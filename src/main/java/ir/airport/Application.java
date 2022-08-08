package ir.airport;

import ir.airport.repository.impl.TicketRepositoryImpl;
import ir.airport.repository.impl.UserRepositoryImpl;
import ir.airport.utility.Context;
import ir.airport.utility.HibernateUtil;


public class Application {
    public static void main(String[] args) {
        HibernateUtil.getEntityManager();
        Context.first.startMenu();
    }

}
