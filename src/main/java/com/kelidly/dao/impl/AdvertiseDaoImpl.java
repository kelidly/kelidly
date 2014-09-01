package com.kelidly.dao.impl;


import org.springframework.stereotype.Component;

import com.kelidly.dao.AdvertiseDao;
import com.kelidly.entity.Advertise;


@Component("advertiseDao")
@SuppressWarnings("unchecked")
public class AdvertiseDaoImpl extends ObjectDaoImpl<Advertise> implements AdvertiseDao{

	@Override
	public Advertise queryBean(int AdvertiseId) {
		return (Advertise)getByPk(Advertise.class, AdvertiseId);
	}

	@Override
	public Boolean update(Advertise bean) {
/*		String hql = "update AdvertiseBean set content='" + bean.getContent()  
				+ "' where id= " + bean.getId();

		Boolean flag =  update(hql) > 0;*/
		return false;
	}



	

}
