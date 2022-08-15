package com.coffee.ihorko.web;

import com.coffee.ihorko.data.PizzaOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("pizzaOrder", new PizzaOrder());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(PizzaOrder pizzaOrder) {
        log.info("Order submitted: " + pizzaOrder);
        return "redirect:/";
    }
}