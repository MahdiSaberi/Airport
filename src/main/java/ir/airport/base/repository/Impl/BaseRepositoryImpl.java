package ir.airport.base.repository.Impl;

import ir.airport.base.entity.BaseEntity;
import ir.airport.base.repository.BaseRepository;
import ir.airport.utility.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.io.Serializable;
import java.util.List;

public abstract class BaseRepositoryImpl<E extends BaseEntity<ID>,ID extends Serializable> implements BaseRepository<E,ID> {

    protected final EntityManager entityManager = HibernateUtil.getEntityManager();

    public abstract Class<E> getEntityClass();

    @Override
    public E save(E e) {
        entityManager.persist(e);
        return e;
    }

    @Override
    public void update(E e) {
        entityManager.merge(e);
    }

    @Override
    public void update(ID id) {
        entityManager.merge(findById(id));
    }

    @Override
    public void delete(ID id) {
        entityManager.remove(findById(id));
    }

    @Override
    public E findById(ID id) {
        return entityManager.createQuery("e from "+getEntityClass()+"e where e.id =: id",
                getEntityClass()).setParameter("id",id).getSingleResult();
    }

    @Override
    public List<E> findAll() {
        return entityManager.createQuery("from "+getEntityClass(),getEntityClass()).getResultList();
    }

    @Override
    public void beginTransaction() {
        entityManager.getTransaction().begin();
    }

    @Override
    public void commitTransaction() {
        entityManager.getTransaction().commit();
    }

    @Override
    public void rollback() {
        entityManager.getTransaction().rollback();
    }

    @Override
    public EntityTransaction getTransaction() {
        return entityManager.getTransaction();
    }
}
