package top.catoy.domain.customer.gateway;

import top.catoy.domain.customer.Customer;

public interface CustomerGateway {
    Customer getByById(String customerId);
}
