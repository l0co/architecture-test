package com.lifeinide.architecture.module.order;

import com.lifeinide.architecture.infra.Entity;
import com.lifeinide.architecture.module.pizza.Pizza;
import com.lifeinide.architecture.module.pizza.PizzaType;
import com.lifeinide.architecture.module.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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

    @Setter(AccessLevel.PROTECTED)
    private OrderStatus status;

    @Setter(AccessLevel.PROTECTED)
    private Pizza pizza;

    @Builder
    public Order(User user, PizzaType pizzaType) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.pizzaType = pizzaType;
        this.price = pizzaType.getPrice();
        this.status = OrderStatus.SUBMITTED;
    }
    
}
