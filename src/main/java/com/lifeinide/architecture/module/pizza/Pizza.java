package com.lifeinide.architecture.module.pizza;

import com.lifeinide.architecture.infra.Entity;
import com.lifeinide.architecture.module.order.Order;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * @author Lukasz Frankowski
 */
@Entity
@Getter
@Setter(AccessLevel.PROTECTED)
public class Pizza {

    private UUID id;
    private PizzaType type;
    private Order order;

    @Builder
    private Pizza(Order order) {
        this.id = UUID.randomUUID();
        this.order = order;
        this.type = order.getPizzaType();
    }
    
}
