package com.lifeinide.architecture.module.oven;

import com.lifeinide.architecture.infra.Repository;
import com.lifeinide.architecture.module.oven.Oven.OvenBuilder;
import com.lifeinide.architecture.module.pizza.Pizza;
import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Lukasz Frankowski
 */
@Service
class OvenService implements OvenPort { // nobody will use this class for dependency injection because it's protected, please use port

    @Autowired private Repository ovenRepository;

    private Queue<Oven> freeOvens = new ArrayBlockingQueue<>(100);

    /**********************************************************************************************************
     * Hexagonal port to oven service is presented by the public interface here
     **********************************************************************************************************/

    @Override
    public Oven create(OvenBuilder builder) {
        Oven oven = builder.build();
        freeOvens.add(oven);
        ovenRepository.save(oven);
        return oven;
    }

    @Override
    public void bake(@NonNull Pizza pizza) {
        Oven oven = freeOvens.poll();
        if (oven == null)
            throw new RuntimeException("No free ovens");
        bake(oven, pizza);
    }

    /**********************************************************************************************************
     * Not exposed, module internals
     **********************************************************************************************************/

    @PostConstruct
    private void init() {
        freeOvens.addAll(ovenRepository.findFreeOvens());
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
