package com.example.pizzarestapi.data;


import com.example.pizzarestapi.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}

