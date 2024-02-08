package com.lifeinide.architecture.infra;

import com.lifeinide.architecture.module.oven.Oven;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * @author Lukasz Frankowski
 */
@org.springframework.stereotype.Repository
public class Repository {

    public void save(@NonNull Object object) {
        // TODO implement Repository.save()
    }

    public List<Oven> findFreeOvens() {
        // TODO implement Repository.findFreeOvens()
        return List.of();
    }

}
