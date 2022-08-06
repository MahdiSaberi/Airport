package ir.airport.service.impl;

import ir.airport.base.service.impl.BaseServiceImpl;
import ir.airport.entity.User;
import ir.airport.repository.UserRepository;
import ir.airport.service.UserService;

public class UserServiceImpl extends BaseServiceImpl<User,Long, UserRepository> implements UserService {
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }
}
