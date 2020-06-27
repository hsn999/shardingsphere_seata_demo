package org.pay.sharding.controller;

import java.util.Random;

import org.pay.sharding.domain.Pay;
import org.pay.sharding.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {
    @Autowired
    private PayService payService;

    //@PostMapping("pay")
    
    @RequestMapping("pay")
    public String pay(@RequestBody Pay pay) {
        return payService.pay(pay);
    }
    
	/*
	 * @RequestParam("productId") Long productId,
	 * 
	 * @RequestParam("userId") Long userId,
	 * 
	 * @RequestParam("buyCount") int count
	 */
    
    @RequestMapping("pay1")
    public String pay( ) {
    	
        Pay pay = new Pay();
        pay.setMoney(100);
        pay.setUserId(new Random().nextLong());
		return payService.pay(pay );
    }
}
