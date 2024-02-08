package com.lifeinide.architecture.module.order;

import com.lifeinide.architecture.infra.Repository;
import com.lifeinide.architecture.module.order.Order.OrderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

/**
 * @author Lukasz Frankowski
 */
@Service
public class OrderService {

    @Autowired
    private Repository repository;

    public Order create(@NonNull OrderBuilder builder) {
        Order order = builder.build();
        repository.save(order);
        return order;
    }

}
