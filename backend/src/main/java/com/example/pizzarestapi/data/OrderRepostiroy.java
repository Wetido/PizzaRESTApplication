package com.example.pizzarestapi.data;

import com.example.pizzarestapi.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepostiroy extends CrudRepository<Order, Long> {

    Order save(Order order);
}
