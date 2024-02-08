package com.lifeinide.architecture.module.pizza;

import com.lifeinide.architecture.infra.Repository;
import com.lifeinide.architecture.module.pizza.Pizza.PizzaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

    @Autowired
    private Repository repository;

    public Pizza create(@NonNull PizzaBuilder builder) {
        Pizza pizza = builder.build();
        repository.save(pizza);
        // TODOLF create real pizza, man
        return pizza;
    }


}
