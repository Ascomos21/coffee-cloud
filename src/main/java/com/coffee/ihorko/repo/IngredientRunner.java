package com.coffee.ihorko.repo;

import com.coffee.ihorko.model.Ingredient;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static com.coffee.ihorko.model.Ingredient.Type.*;

@Component
public class IngredientRunner {

    @Bean
    public ApplicationRunner dataLoader(IngredientRepository repo) {
        return args -> {
            repo.save(new Ingredient("FLTO", "Flour Tortilla", WRAP));
            repo.save(new Ingredient("COTO", "Corn Tortilla", WRAP));
            repo.save(new Ingredient("GRBF", "Ground Beef", PROTEIN));
            repo.save(new Ingredient("CARN", "Carnitas", PROTEIN));
            repo.save(new Ingredient("TMTO", "Diced Tomatoes", VEGGIES));
            repo.save(new Ingredient("LETC", "Lettuce", VEGGIES));
            repo.save(new Ingredient("CHED", "Cheddar", CHEESE));
            repo.save(new Ingredient("JACK", "Monterrey Jack", CHEESE));
            repo.save(new Ingredient("SLSA", "Salsa", SAUCE));
            repo.save(new Ingredient("SRCR", "Sour Cream", SAUCE));
        };
    }
}
