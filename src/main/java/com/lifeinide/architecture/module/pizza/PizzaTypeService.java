package com.lifeinide.architecture.module.pizza;

import com.lifeinide.architecture.infra.Repository;
import com.lifeinide.architecture.module.pizza.PizzaType.PizzaTypeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class PizzaTypeService {

    @Autowired private Repository repository;

    public PizzaType create(@NonNull PizzaTypeBuilder builder) {
        PizzaType pizzaType = builder.build();
        repository.save(pizzaType);
        return pizzaType;
    }

}
