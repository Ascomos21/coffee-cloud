package com.coffee.ihorko.web;

import com.coffee.ihorko.model.Ingredient;
import com.coffee.ihorko.model.Ingredient.Type;
import com.coffee.ihorko.model.Pizza;
import com.coffee.ihorko.repo.IngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("pizzaOrder")
public class DesignPizzaController {

    private final IngredientRepository ingredientRepo;

    @Autowired
    public DesignPizzaController(
            IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = ingredientRepo.findAll();
        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.name().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @GetMapping
    public String showDesignForm(Model model) {
        model.addAttribute("pizza", new Pizza());
        return "design";
    }

    @PostMapping
    public String processPizza(@Valid @ModelAttribute("pizza") Pizza pizza, Errors errors) {

        if (errors.hasErrors()) {
            return "design";
        }
        // Save the pizza...
        log.info("Processing pizza: " + pizza);
        return "redirect:/orders/current";
    }


    private Iterable<Ingredient> filterByType(
            Iterable<Ingredient> ingredients, Type type) {
        return StreamSupport.stream(ingredients.spliterator(), false)
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
