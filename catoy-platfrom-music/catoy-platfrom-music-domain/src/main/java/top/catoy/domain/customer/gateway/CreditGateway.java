package top.catoy.domain.customer.gateway;

import top.catoy.domain.customer.Credit;

//Assume that the credit info is in another distributed Service
public interface CreditGateway {
    Credit getCredit(String customerId);
}
