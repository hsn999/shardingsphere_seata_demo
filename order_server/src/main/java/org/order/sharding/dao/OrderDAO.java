package org.order.sharding.dao;

import org.apache.ibatis.annotations.Insert;
import org.order.sharding.domain.Order;

public interface OrderDAO {

    @Insert("insert into t_order(t_pay_id, user_id) values(#{tPayId}, #{userId})")
    int insert(Order order);
}
