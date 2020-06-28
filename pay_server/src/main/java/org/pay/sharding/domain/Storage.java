package org.pay.sharding.domain;

import lombok.Data;

@Data
public class Storage {

    private Long id;

    private Long tPayId;

    private Long productId;
    
    private Long total;
    
    private double price;
}
