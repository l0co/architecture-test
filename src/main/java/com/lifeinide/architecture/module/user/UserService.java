package com.lifeinide.architecture.module.user;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

/**
 * @author Lukasz Frankowski
 */
@Service
public class UserService {

    public User create(@NonNull String name) {
        return User.builder()
            .name(name)
            .build();
    }

}
