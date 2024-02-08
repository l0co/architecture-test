package com.lifeinide.architecture.module.oven;

import com.lifeinide.architecture.infra.Repository;
import com.lifeinide.architecture.integration.DroneIntegrationService;
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
public class OvenService {

    @Autowired private Repository ovenRepository;
    @Autowired private BakingService bakingService;
    @Autowired private DroneIntegrationService droneIntegrationService;

    private Queue<Oven> freeOvens = new ArrayBlockingQueue<>(100);

    public Oven create(OvenBuilder builder) {
        Oven oven = builder.build();
        freeOvens.add(oven);
        ovenRepository.save(oven);
        return oven;
    }

    public void bake(@NonNull Pizza pizza) {
        Oven oven = freeOvens.poll();
        if (oven == null)
            throw new RuntimeException("No free ovens");
        bake(oven, pizza);
    }

    @PostConstruct
    private void init() {
        freeOvens.addAll(ovenRepository.findFreeOvens());
    }

    @SneakyThrows
    private void bake(@NonNull Oven oven, @NonNull Pizza pizza) {
        oven.startBaking(pizza);
        droneIntegrationService.sendDroneAndWait(oven.getCurrentPizza(), "preparationRoom", oven);
        bakingService.turnOnOvenWithOvenWebserviceAndWait(oven);
        bakingService.waitUntilBaked(oven);
        bakingService.turnOffOvenWithOvenWebserviceAndWait(oven);
        droneIntegrationService.sendDroneAndWait(oven.getCurrentPizza(), oven, "deliveryRoom");
        oven.stopBaking();
    }

}
