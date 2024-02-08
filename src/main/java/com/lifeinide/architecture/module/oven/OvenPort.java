package com.lifeinide.architecture.module.oven;

import com.lifeinide.architecture.module.pizza.Pizza;
import org.springframework.lang.NonNull;

/**
 * @author Lukasz Frankowski
 */
public interface OvenPort {

    Oven create(Oven.OvenBuilder builder);

    void bake(@NonNull Pizza pizza);
    
}
