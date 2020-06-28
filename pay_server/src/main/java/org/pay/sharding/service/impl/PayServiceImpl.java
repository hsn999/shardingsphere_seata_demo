package org.pay.sharding.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import org.pay.sharding.dao.PayDAO;
import org.pay.sharding.domain.Order;
import org.pay.sharding.domain.Pay;
import org.pay.sharding.domain.Storage;
import org.pay.sharding.feign.OrderFeign;
import org.pay.sharding.feign.StorageFeign;
import org.pay.sharding.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private PayDAO payDAO;
    @Autowired
    private OrderFeign orderFeign;
    @Autowired
    private StorageFeign storageFeign;



    @GlobalTransactional
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String pay(Pay pay){
        //在调用db时设置，可以对事务类型进行切换
        //其他服务中也需要配置
        TransactionTypeHolder.set(TransactionType.BASE);
        payDAO.insert(pay);

        Order order = new Order();
        order.setTPayId(pay.getId());
        order.setUserId(pay.getUserId());
        orderFeign.addOrder(order);
        
        Storage storage = new Storage();
        storage.setPrice(pay.getMoney());
        storage.setTPayId(pay.getId());
        storage.setPrice(22l);
        storage.setProductId(23l);
		String s = storageFeign.addStorage(storage );
		System.out.println(s);
        //模拟异常
//        int i = 1/0;
        return "success";
    }
}
