package org.order.sharding.service.impl;

import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import org.order.sharding.dao.OrderDAO;
import org.order.sharding.domain.Order;
import org.order.sharding.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Override
    public String addOrder(Order order) {
        TransactionTypeHolder.set(TransactionType.BASE);
        orderDAO.insert(order);
        return "success";
    }
}
