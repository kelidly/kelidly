package com.kelidly.dao;

import com.kelidly.entity.Advertise;

public interface AdvertiseDao extends BaseDao<Advertise>{

	Advertise queryBean(int advertiseId);

	Boolean update(Advertise bean);

	

}
