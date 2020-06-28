package org.storge.sharding.dao;

import org.apache.ibatis.annotations.Insert;
import org.storge.sharding.domain.Storage;

public interface StorageDAO {

    @Insert("insert into t_storage(t_pay_id, product_id,total,price) values(#{tPayId},'888','1', #{price})")
    int insert(Storage storage);
}
