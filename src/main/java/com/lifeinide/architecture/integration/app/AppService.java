package com.lifeinide.architecture.integration.app;

import com.lifeinide.architecture.module.order.Order;
import com.lifeinide.architecture.module.order.OrderService;
import com.lifeinide.architecture.module.pizza.PizzaType;
import com.lifeinide.architecture.module.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

/**
 * @author Lukasz Frankowski
 */
@Service
public class AppService {

    @Autowired private OrderService orderService;

    public Order placeOrder(@NonNull User user, @NonNull PizzaType pizzaType) {
        return orderService.create(Order.builder()
            .user(user)
            .pizzaType(pizzaType));
    }

    public void accomplishOrder(@NonNull Order order) {
        orderService.pay(order);
        orderService.accomplish(order);
        orderService.send(order);
    }

}
