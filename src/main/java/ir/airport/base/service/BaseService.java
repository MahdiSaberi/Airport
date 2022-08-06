package ir.airport.base.service;

import ir.airport.base.entity.BaseEntity;
import ir.airport.base.repository.BaseRepository;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends BaseEntity<ID>,ID extends Serializable> {
    E save(E e);

    void update(E e);

    void update(ID id);

    void delete(ID id);

    E findById(ID id);

    List<E> findAll();
}
