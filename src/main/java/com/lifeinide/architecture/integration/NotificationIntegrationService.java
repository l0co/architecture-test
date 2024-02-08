package com.lifeinide.architecture.integration;

import com.lifeinide.architecture.module.user.User;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

/**
 * @author Lukasz Frankowski
 */
@Service
public class NotificationIntegrationService {

    public void send(@NonNull User user, @NonNull String notification) {
        // TODO implement NotificationIntegrationService.send()
    }

}
