package com.coffee.ihorko.repo;

import com.coffee.ihorko.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

}