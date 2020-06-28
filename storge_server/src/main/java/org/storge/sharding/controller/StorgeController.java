package org.storge.sharding.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.storge.sharding.domain.Storage;
import org.storge.sharding.service.StorageService;

@RestController
public class StorgeController {
    @Autowired
    private StorageService storageService;

    @PostMapping("addStorage")
    public String addStorage(@RequestBody Storage storage) {
        return storageService.addStorage(storage);
    	//return "1";
    }
    
    @GetMapping("addStorge1")
    public String addStorge1() {
    	Storage storage = new Storage();
		//storage.setId(new Random().nextLong());
		storage.setPrice(11.20D);
		storage.setProductId(1L);
		storage.setTotal(2L);
		storage.setTPayId(22345l);
        return storageService.addStorage(storage);
    	//return "1";
    }
}
