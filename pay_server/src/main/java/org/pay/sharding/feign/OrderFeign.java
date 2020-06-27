package org.pay.sharding.feign;

import org.pay.sharding.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "sharding-order-service", url = "127.0.0.1:8081")
public interface OrderFeign {

    @PostMapping("addOrder")
    String addOrder(@RequestBody Order order);
}
