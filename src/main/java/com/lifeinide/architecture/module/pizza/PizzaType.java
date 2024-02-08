package com.lifeinide.architecture.module.pizza;

import com.lifeinide.architecture.infra.Entity;
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
public class PizzaType {

    private UUID id;

    @Setter(AccessLevel.PROTECTED)
    private String name;

    @Setter(AccessLevel.PROTECTED)
    private BigDecimal price;

    @Builder
    public PizzaType(String name, BigDecimal price) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
    }
}
