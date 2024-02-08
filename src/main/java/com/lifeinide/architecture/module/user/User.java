package com.lifeinide.architecture.module.user;

import com.lifeinide.architecture.infra.Entity;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

/**
 * @author Lukasz Frankowski
 */
@Entity
@Getter
public class User {

    private UUID id;
    private String name;

    @Builder
    public User(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }
    
}
