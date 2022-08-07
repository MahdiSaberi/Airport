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



    public void initUsers(){
        User user1 = new User("Mahdi","Saberi","mahdi","123");
        User user2 = new User("Abbas","Jadidi","abas","1234");
        User user3 = new User("Sajad","Qaribi","saji33","12345");
        User user4 = new User("Shima","Sadeghpoor","shimsad","123456");
        User user5 = new User("Zahra","Akbari","zahraakbari","1234567");

        Context.user.save(user1);
        Context.user.save(user2);
        Context.user.save(user3);
        Context.user.save(user4);
        Context.user.save(user5);
        System.out.println("Users Initialized Successfully!");
    }

}
