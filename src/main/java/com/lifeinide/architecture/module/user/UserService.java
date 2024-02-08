package com.lifeinide.architecture.module.user;

import com.lifeinide.architecture.infra.Repository;
import com.lifeinide.architecture.module.user.User.UserBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

/**
 * @author Lukasz Frankowski
 */
@Service
public class UserService {

    @Autowired private Repository repository;

    public User create(@NonNull UserBuilder builder) {
        User user = builder.build();
        repository.save(user);
        return user;
    }

}
