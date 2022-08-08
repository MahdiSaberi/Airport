package ir.airport.utility;

import ir.airport.entity.Airline;
import ir.airport.entity.Ticket;
import ir.airport.entity.User;

public class DatabaseInit {

    public static void initDatabase(){
        initUsers();
        initAirlinesWithTickets();
    }

    public static void initAirlinesWithTickets(){
        Airline airline1 = new Airline("Mahan","321");
        Airline airline2 = new Airline("Zagros","4321");
        Airline airline3 = new Airline("Iran Air","54321");

        Context.airline.save(airline1);
        Context.airline.save(airline2);
        Context.airline.save(airline3);

        System.out.println("Airlines Initialized successfully!");

        Ticket ticket0 = new Ticket(airline1,"Tehran","Qazvin",900L);
        Ticket ticket1 = new Ticket(airline2,"Tehran","Isfahan",400L);
        Ticket ticket2 = new Ticket(airline1,"Kish","Mashhad",300L);
        Ticket ticket3 = new Ticket(airline3,"Abadan","Tehran",250L);
        Ticket ticket4 = new Ticket(airline3,"Mashhad","Tehran",150L);
        Ticket ticket5 = new Ticket(airline2,"Tabriz","Bushehr",780L);

        Context.ticket.save(ticket0);
        Context.ticket.save(ticket1);
        Context.ticket.save(ticket2);
        Context.ticket.save(ticket3);
        Context.ticket.save(ticket4);
        Context.ticket.save(ticket5);

        System.out.println("Tickets Initialized successfully!");
    }

    public static void initUsers(){
        User user1 = new User("Mahdi","Saberi","mahdi","123");
        User user2 = new User("Abbas","Jadidi","abas","1234");
        User user3 = new User("Sajad","Qaribi","saji33","12345");
        User user4 = new User("Shima","Sadeghpoor","shimsad","123456");
        User user5 = new User("Zahra","Akbari","zahraakbari","1234567");

        Context.user.save(user1);
        Context.user.save(user2);
        Context.user.save(user3);
        Context.user.save(user4);
        Context.user.save(user5);
        System.out.println("Users Initialized Successfully!");
    }
}
