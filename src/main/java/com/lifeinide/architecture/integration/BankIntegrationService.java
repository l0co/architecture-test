package com.lifeinide.architecture.integration;

import com.lifeinide.architecture.module.order.Order;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

/**
 * @author Lukasz Frankowski
 */
@Service
public class BankIntegrationService {

    public boolean isConfirmedPayment(@NonNull Order order) {
        // TODO implement BankIntegrationService.isConfirmedPayment()
        return true;
    }

}
