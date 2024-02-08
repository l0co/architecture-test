package com.lifeinide.architecture.module.oven;

import com.lifeinide.architecture.module.pizza.Pizza;
import lombok.SneakyThrows;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Lukasz Frankowski
 */
@Service
public class OvenService {

    private Queue<Oven> freeOvens = new ArrayBlockingQueue<>(100);

    public Oven create() {
        Oven oven = Oven.builder()
            .build();
        freeOvens.add(oven);
        return oven;
    }

    public void bake(@NonNull Pizza pizza) {
        Oven oven = freeOvens.poll();
        if (oven == null)
            throw new RuntimeException("No free ovens");
        bake(oven, pizza);
    }

    @SneakyThrows
    private void bake(@NonNull Oven oven, @NonNull Pizza pizza) {
        oven.startBaking(pizza);
        doBake(oven);
        oven.finishBaking();
    }

    private void doBake(@NonNull Oven oven) {
        /* TODO implement baking
        *   1. send drone to insert pizza into oven
        *   2. turn on oven with oven webservice
        *   3. wait 10 min
        *   4. turn off over with over webservice
        *   5. send drone to move pizza from oven to delivery room */
    }

}
