package com.lifeinide.architecture.module.order;

import com.lifeinide.architecture.infra.Repository;
import com.lifeinide.architecture.integration.UpsIntegrationService;
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
    @Autowired private UpsIntegrationService upsIntegrationService;

    public Order create(@NonNull OrderBuilder builder) {
        Order order = builder.build();
        repository.save(order);
        return order;
    }

    public void pay(@NonNull Order order) {
        if (order.getStatus() != OrderStatus.SUBMITTED)
            throw new RuntimeException("Order is not submitted");

        // TODOLF check payment
        order.pay();
    }

    public void accomplish(@NonNull Order order) {
        if (order.getStatus() != OrderStatus.PAID)
            throw new RuntimeException("Order is not paid");

        Pizza pizza = pizzaService.create(Pizza.builder()
            .order(order));
        order.start(pizza);
        ovenService.bake(pizza);
    }

    public void send(@NonNull Order order) {
        if (order.getStatus() != OrderStatus.DONE)
            throw new RuntimeException("Order is not done");

        upsIntegrationService.send(order.getPizza(), order.getUser());
        order.send();
    }

}
