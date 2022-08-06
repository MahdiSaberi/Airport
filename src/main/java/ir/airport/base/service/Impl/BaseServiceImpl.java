package ir.airport.base.service.Impl;

import ir.airport.base.entity.BaseEntity;
import ir.airport.base.repository.BaseRepository;
import ir.airport.base.service.BaseService;

import java.io.Serializable;
import java.util.List;

public class BaseServiceImpl<E extends BaseEntity<ID>,ID extends Serializable,R extends BaseRepository<E,ID>> implements BaseService<E,ID> {

    protected R repository;

    @Override
    public E save(E e) {
        try {
            if (!repository.getTransaction().isActive()) {
                repository.beginTransaction();
                repository.save(e);
            } else {
                repository.save(e);
            }
            repository.commitTransaction();
        }catch (Exception exception){
            exception.printStackTrace();
            repository.rollback();
        }

        return e;
    }

    @Override
    public void update(E e) {
        try {
            if (repository.findById(e.getId()) != null) {
                repository.beginTransaction();
                repository.update(e);
                repository.commitTransaction();
            }
        }catch (Exception exception){
            exception.printStackTrace();
            repository.rollback();
        }

    }

    @Override
    public void update(ID id) {
        try {
            repository.beginTransaction();
            repository.update(id);
            repository.commitTransaction();
        }catch (Exception exception){
            exception.printStackTrace();
            repository.rollback();
        }
    }

    @Override
    public void delete(ID id) {
        try {
            repository.beginTransaction();
            repository.delete(id);
            repository.commitTransaction();
        }catch (Exception exception){
            exception.printStackTrace();
            repository.rollback();
        }
    }

    @Override
    public E findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }
}
