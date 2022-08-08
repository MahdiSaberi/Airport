package ir.airport.repository.impl;

import ir.airport.base.repository.impl.BaseRepositoryImpl;
import ir.airport.entity.User;
import ir.airport.repository.UserRepository;
import ir.airport.utility.Context;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

import java.util.List;

public class UserRepositoryImpl extends BaseRepositoryImpl<User,Long> implements UserRepository {

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public User findByUsername(String username) {
        return entityManager.createQuery("from User"+" where username =: username",User.class).
                setParameter("username",username).getSingleResult();
    }

}
