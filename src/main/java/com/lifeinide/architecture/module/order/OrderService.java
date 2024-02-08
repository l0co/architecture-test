package com.lifeinide.architecture.module.order;

import com.lifeinide.architecture.infra.Repository;
import com.lifeinide.architecture.module.order.Order.OrderBuilder;
import com.lifeinide.architecture.module.oven.OvenService;
import com.lifeinide.architecture.module.pizza.Pizza;
import com.lifeinide.architecture.module.pizza.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

/**
 * @author Lukasz Frankowski
 */
@Service
public class OrderService {

    @Autowired private Repository repository;
    @Autowired private PizzaService pizzaService;
    @Autowired private OvenService ovenService;

    public Order create(@NonNull OrderBuilder builder) {
        Order order = builder.build();
        repository.save(order);
        return order;
    }

    public void pay(@NonNull Order order) {
        // TODOLF check payment
        order.pay();
    }

    public void bake(@NonNull Order order) {
        Pizza pizza = pizzaService.create(Pizza.builder()
            .order(order));
        order.startBaking(pizza);
        ovenService.bake(pizza);
    }

}
