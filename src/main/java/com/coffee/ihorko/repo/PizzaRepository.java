package com.coffee.ihorko.repo;

import com.coffee.ihorko.model.Pizza;
import org.springframework.data.repository.CrudRepository;

public interface PizzaRepository extends CrudRepository<Pizza, Long> {
}
