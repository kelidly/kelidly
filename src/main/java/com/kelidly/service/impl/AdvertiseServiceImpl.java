package com.kelidly.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.kelidly.dao.AdvertiseDao;
import com.kelidly.entity.Advertise;
import com.kelidly.service.AdvertiseService;

@Component("advertiseService")
public class AdvertiseServiceImpl implements AdvertiseService {

	@Resource(name="advertiseDao")
	AdvertiseDao advertiseDao;

	public Advertise queryBean(int advertiseId) {
		return advertiseDao.queryBean(advertiseId);
	}

	public Boolean update(Advertise bean) {
		return advertiseDao.update(bean);
	}

	@Override
	public boolean saveBean(Advertise bean) {
		
		try {
			advertiseDao.create(bean);
		} catch (Exception e) {
			return false;
		}
		return true;
		
		
	}
	
	
}
