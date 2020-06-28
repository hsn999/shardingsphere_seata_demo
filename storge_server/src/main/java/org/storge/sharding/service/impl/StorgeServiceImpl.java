package org.storge.sharding.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.storge.sharding.dao.StorageDAO;
import org.storge.sharding.domain.Storage;
import org.storge.sharding.service.StorageService;

import io.seata.core.context.RootContext;

@Service
public class StorgeServiceImpl implements StorageService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StorgeServiceImpl.class);
    @Autowired
    private StorageDAO storageDAO;

	@Override
	@Transactional
	public String addStorage(Storage storage) {
		// TODO Auto-generated method stub
		String xid = RootContext.getXID();
		System.out.println("============================"+xid);
		storageDAO.insert(storage);
		
		//模擬异常
		//int a = 4/0;
		
		
		return "success";
	}

}
