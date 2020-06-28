package org.pay.sharding.feign;

import org.pay.sharding.domain.Storage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "sharding-storage-service", url = "127.0.0.1:8082")
public interface StorageFeign {

    @PostMapping("addStorage")
    String addStorage(@RequestBody Storage storage);
}
