package com.lifeinide.architecture.module.order;

import com.lifeinide.architecture.infra.Entity;
import com.lifeinide.architecture.module.pizza.Pizza;
import com.lifeinide.architecture.module.pizza.PizzaType;
import com.lifeinide.architecture.module.user.User;
import lombok.Builder;
import lombok.Getter;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author Lukasz Frankowski
 */
@Entity
@Getter
public class Order {

    private UUID id;
    private User user;
    private PizzaType pizzaType;
    private BigDecimal price;
    private OrderStatus status;
    private Pizza pizza;

    @Builder
    private Order(@NonNull User user, @NonNull PizzaType pizzaType) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.pizzaType = pizzaType;
        this.price = pizzaType.getPrice();
        this.status = OrderStatus.SUBMITTED;
    }

    // not exposed externally because somebody can think this is right method to pay
    // while real pay is done in a service, this is only the status marker
    void pay() {
        this.status = OrderStatus.PAID;
    }

    // not exposed externally because somebody can think this is right method to pay
    // while real baking is done in a service, this is only the status marker
    void startBaking(@NonNull Pizza pizza) {
        this.pizza = pizza;
        this.status = OrderStatus.IN_PROGRESS;
    }

}
