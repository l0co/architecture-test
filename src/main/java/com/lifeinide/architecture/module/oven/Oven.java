package com.lifeinide.architecture.module.oven;

import com.lifeinide.architecture.infra.Entity;
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
public class Oven {

    private UUID id;

    @Setter(AccessLevel.PROTECTED)
    private OverStatus status;

    @Builder
    public Oven() {
        this.status = OverStatus.DISABLED;
    }
}
