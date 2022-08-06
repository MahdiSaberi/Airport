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
}
