package com.coffee.ihorko.repo;

import com.coffee.ihorko.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}