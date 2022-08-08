package ir.airport.repository.impl;

import ir.airport.base.repository.impl.BaseRepositoryImpl;
import ir.airport.entity.User;
import ir.airport.repository.UserRepository;


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
