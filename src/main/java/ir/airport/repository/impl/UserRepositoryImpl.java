package ir.airport.repository.impl;

import ir.airport.base.repository.impl.BaseRepositoryImpl;
import ir.airport.entity.User;
import ir.airport.repository.UserRepository;

public class UserRepositoryImpl extends BaseRepositoryImpl<User,Long> implements UserRepository {

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

}
