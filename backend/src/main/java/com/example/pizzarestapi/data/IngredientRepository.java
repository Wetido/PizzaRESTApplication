package com.example.pizzarestapi.data;


import com.example.pizzarestapi.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
