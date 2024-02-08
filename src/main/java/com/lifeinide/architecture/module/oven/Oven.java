package com.lifeinide.architecture.module.oven;

import com.lifeinide.architecture.infra.Entity;
import com.lifeinide.architecture.module.pizza.Pizza;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.util.UUID;

/**
 * @author Lukasz Frankowski
 */
@Entity
@Getter
public class Oven {

    private UUID id;

    @Setter(AccessLevel.PROTECTED)
    private OverStatus status;

    @Setter(AccessLevel.PROTECTED)
    private Pizza currentPizza;

    @Builder
    private Oven() {
        this.status = OverStatus.FREE;
    }

    public boolean canBeUsed() {
        return status == OverStatus.FREE;
    }

    // not exposed externally because somebody can think this is right method to start baking
    // while real baking is done in a service, this is only the status marker
    protected void startBaking(@NonNull Pizza pizza) {
        setStatus(OverStatus.BUSY);
        setCurrentPizza(pizza);
    }

    // not exposed externally because somebody can think this is right method to stop baking
    // while real baking is done in a service, this is only the status marker
    protected void finishBaking() {
        setStatus(OverStatus.FREE);
        setCurrentPizza(null);
    }

}
