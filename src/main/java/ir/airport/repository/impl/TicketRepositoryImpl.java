package ir.airport.repository.impl;

import ir.airport.base.repository.impl.BaseRepositoryImpl;
import ir.airport.entity.Ticket;
import ir.airport.repository.TicketRepository;
import ir.airport.repository.impl.enumeration.Sort;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class TicketRepositoryImpl extends BaseRepositoryImpl<Ticket,Long> implements TicketRepository {

    @Override
    public Class<Ticket> getEntityClass() {return Ticket.class;}

    @Override
    public List<Ticket> orderBy(String order, Sort type){

        if(order.equals("label")){
            if(type == Sort.ASC)
                return entityManager.createQuery("from Ticket order by airline.label asc ",Ticket.class).getResultList();

            else
                return entityManager.createQuery("from Ticket order by airline.label desc ",Ticket.class).getResultList();
        }

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ticket> criteriaQuery = criteriaBuilder.createQuery(Ticket.class);
        Root<Ticket> root = criteriaQuery.from(Ticket.class);

        if(type == Sort.ASC)
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(order)));

        else if(type == Sort.DESC)
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get(order)));

        CriteriaQuery<Ticket> select = criteriaQuery.select(root);
        TypedQuery<Ticket> query = entityManager.createQuery(select);
        List<Ticket> tickets = query.getResultList();

        return tickets;
    }

}
