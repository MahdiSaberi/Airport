package ir.airport.ui;
import ir.airport.entity.Ticket;
import ir.airport.entity.User;
import ir.airport.repository.impl.enumeration.Sort;
import ir.airport.utility.Context;
import jakarta.persistence.criteria.Order;

import java.util.List;
import java.util.stream.Collectors;

import static ir.airport.base.ui.BaseMenu.number;
import static ir.airport.base.ui.BaseMenu.scaffolding;

public class TicketMenu {

    public void ticketList(String order, Sort type){

        List<Ticket> tickets;

        if(order.equals("label")){
            tickets = Context.ticket.orderByLabel(type);
        }

        else
            tickets = Context.ticket.orderBy(order, type);

        tickets.forEach(ticket -> {
            scaffolding();
            System.out.println(ticket.getId()+". Label: "+ticket.getAirline().getLabel());
            System.out.println("Origin: "+ticket.getOrigin()+"\t"+"Destination: "+ticket.getDestination()+"\t"+"Price: "+ticket.getPrice()+"\t"+"Reserved: "+ticket.getReservedNumber());
        });
    }

    public void ticketsUniqueByUser(User user){
        List<Ticket> tickets = Context.ticket.findAll();
        tickets = tickets.stream().filter(ticket -> ticket.getUsers().contains(user)).collect(Collectors.toList());

        for(Ticket ticket : tickets){
            scaffolding();
            System.out.println(ticket.getId()+". Label: "+ticket.getAirline().getLabel());
            System.out.println("Origin: "+ticket.getOrigin()+"\t"+"Destination: "+ticket.getDestination()+"\t"+"Price: "+ticket.getPrice()
            +"\t"+"Reserved: "+ticket.getReservedNumber());
        }
    }

    public void reserve(User user){
        scaffolding();
        System.out.println("Select Ticket by ID:");
        Long id = number.nextLong();
        Ticket ticket = Context.ticket.findById(id);

        ticket.setReservedNumber(ticket.getReservedNumber()+1);
        ticket.getUsers().add(user);
        Context.ticket.update(ticket);
        System.out.println("Reserved!");
        Context.userMenu.userPage(user);

    }

    public void searching(){

    }

    public void sorting(User user){
        scaffolding();
        System.out.println("Sort by:");
        System.out.println("1 -> Price");
        System.out.println("2 -> Origin");
        System.out.println("3 -> Destination");
        System.out.println("4 -> Label");
        System.out.println("5 -> Back");
        Integer select = number.nextInt();

        switch (select){
            case 1:
                sortType("price");
                break;
            case 2:
                sortType("origin");
                break;
            case 3:
                sortType("destination");
                break;
            case 4:
                sortType("label");
                break;
            case 5:
                Context.userMenu.seeAndBuyTickets(user);
        }
    }

    public void sortType(String order){
        scaffolding();
        System.out.println("    1 -> Ascending");
        System.out.println("    2 -> Descending");

        Integer select = number.nextInt();

        switch (select){
            case 1:
                ticketList(order,Sort.ASC);
                break;
            case 2:
                ticketList(order,Sort.DESC);
                break;
        }
    }
}