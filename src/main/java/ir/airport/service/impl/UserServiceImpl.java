package ir.airport.service.impl;

import ir.airport.base.service.impl.BaseServiceImpl;
import ir.airport.entity.User;
import ir.airport.repository.UserRepository;
import ir.airport.service.UserService;

public class UserServiceImpl extends BaseServiceImpl<User,Long, UserRepository> implements UserService {
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public User findByUsername(String username) {
        User user = null;
        try{
            user = repository.findByUsername(username);
            return user;
        }catch (Exception e){
            System.out.println("Wrong inputs!");
        }
        return user;
    }
}
