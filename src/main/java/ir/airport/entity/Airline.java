package ir.airport.entity;

import ir.airport.base.entity.BaseEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
public class Airline extends BaseEntity<Long> {

    private String label;

    @OneToMany(cascade = CascadeType.REMOVE)
    private Set<Ticket> tickets;

    public Airline() {
    }

    public Airline(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
