package ir.airport.repository;

import ir.airport.base.repository.BaseRepository;
import ir.airport.entity.User;

public interface UserRepository extends BaseRepository<User,Long> {
    User findByUsername(String username);

}
