package com.lifeinide.architecture.infra;

import com.lifeinide.architecture.module.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

/**
 * @author Lukasz Frankowski
 */
@Service
@Slf4j
public class NotificationService {

    public void send(@NonNull User user, @NonNull String notification) {
        log.info("Notification: {} sent to: {}", user, notification);
    }

}
