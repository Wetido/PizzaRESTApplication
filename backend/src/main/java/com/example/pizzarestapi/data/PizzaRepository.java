package com.example.pizzarestapi.data;


import com.example.pizzarestapi.Pizza;
import org.springframework.data.repository.CrudRepository;

public interface PizzaRepository extends CrudRepository<Pizza, Long> {

    Pizza save(Pizza design);
}
