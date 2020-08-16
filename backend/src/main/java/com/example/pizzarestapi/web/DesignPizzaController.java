package com.example.pizzarestapi.web;

import com.example.pizzarestapi.Ingredient;
import com.example.pizzarestapi.Order;
import com.example.pizzarestapi.Pizza;
import com.example.pizzarestapi.data.IngredientRepository;
import com.example.pizzarestapi.data.OrderRepostiroy;
import com.example.pizzarestapi.data.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/design", produces = "application/json")
@CrossOrigin(origins = "*")
public class DesignPizzaController {
    private PizzaRepository pizzaRepository;
    private IngredientRepository ingredientRepository;
    private OrderRepostiroy orderRepostiroy;

    @Autowired
    EntityLinks entityLinks;

    public DesignPizzaController(PizzaRepository pizzaRepository, IngredientRepository ingredientRepository,
                                 OrderRepostiroy orderRepostiroy) {
        this.pizzaRepository = pizzaRepository;
        this.ingredientRepository = ingredientRepository;
        this.orderRepostiroy = orderRepostiroy;
    }

    @GetMapping("/pizzas")
    public Iterable<Pizza> recentPizzas() {
        return pizzaRepository.findAll();
    }


    @GetMapping("/ingredients")
    public Iterable<Ingredient> recentIngredients() {
        return ingredientRepository.findAll();
    }

    @GetMapping("/orders")
    public Iterable<Order> recentOrders() {
        return orderRepostiroy.findAll();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient postTaco(@RequestBody Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }


    @GetMapping("recent/{id}")
    public ResponseEntity<Pizza> tacoById(@PathVariable("id") Long id) {
        Optional<Pizza> optTaco = pizzaRepository.findById(id);
        if (optTaco.isPresent()) {
            return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


}