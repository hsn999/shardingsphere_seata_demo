package org.pay.sharding.domain;

import lombok.Data;

@Data
public class Order {

    private Long id;

    private Long tPayId;

    private Long userId;
}
