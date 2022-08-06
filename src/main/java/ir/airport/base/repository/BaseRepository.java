package ir.airport.base.repository;

import ir.airport.base.entity.BaseEntity;
import jakarta.persistence.EntityTransaction;

import java.io.Serializable;
import java.util.List;

public interface BaseRepository<E extends BaseEntity<ID>,ID extends Serializable> {

    E save(E e);

    void update(E e);

    void update(ID id);

    void delete(ID id);

    E findById(ID id);

    List<E> findAll();

    void beginTransaction();

    void commitTransaction();

    void rollback();

    EntityTransaction getTransaction();
}
