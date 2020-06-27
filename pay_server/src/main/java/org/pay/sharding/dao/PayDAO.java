package org.pay.sharding.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.pay.sharding.domain.Pay;

public interface PayDAO {

    @Insert("insert into t_pay(money, user_id) values(#{money}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Pay pay);
}
