package ir.airport.entity;

import ir.airport.base.entity.BaseEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Ticket extends BaseEntity<Long> {

    @ManyToOne
    private Airline airline;

    private String origin;

    private String destination;

    private Long price;

    @Column(name = "reserved")
    private Integer reservedNumber = 0;

    @ManyToMany
    private List<User> users;

    public Ticket() {
    }

    public Ticket(Airline airline, String origin, String destination, Long price) {
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.price = price;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getReservedNumber() {
        return reservedNumber;
    }

    public void setReservedNumber(Integer reservedNumber) {
        this.reservedNumber = reservedNumber;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
