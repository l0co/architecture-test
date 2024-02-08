package com.lifeinide.architecture.module.oven;

import lombok.SneakyThrows;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

/**
 * An internal module backing service, not appropriate to be used outside this package due to class visibility, but
 * still usable within the module as an autowired bean.
 *
 * @author Lukasz Frankowski
 */
@Service
class BakingService {

    public void turnOnOvenWithOvenWebservice(@NonNull Oven oven) {
        // TODO implement BakingService.turnOnOvenWithOvenWebservice()
    }

    @SneakyThrows
    public void waitUntilBaked(@NonNull Oven oven) {
        // all pizzas are done within 10 mins currently
        // but in the future we plan to introduce over efficiency parameter to improve this
        Thread.sleep(10*60*1000);
    }

    public void turnOffOvenWithOvenWebservice(@NonNull Oven oven) {
        // TODO implement BakingService.turnOffOvenWithOvenWebservice()
    }

}
