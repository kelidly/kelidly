package com.kelidly.dao.impl;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.kelidly.dao.SystemDao;
import com.kelidly.entity.SystemConfig;


@Repository("systemDao")
public class SystemDaoImpl extends ObjectDaoImpl<SystemConfig> implements SystemDao {
	
	@Resource
	private SessionFactory sessionFactory;

	public List getsystem() {		
		
		Session s = sessionFactory.openSession();
		String hql = "from SystemConfig";		
		Query query = s.createQuery(hql);
		List<SystemConfig> list = query.list();	
		s.close();
		return list;
		
	}

	public void updateSystemById(List<SystemConfig> list) {
		update(list);

	}

	@Deprecated
	public List getSystemListBySytle(int i) {		
		Session s = sessionFactory.openSession();
		String hql = "from SystemConfig where status=:status";		
		Query query = s.createQuery(hql);
		query.setInteger("status", i);
		List<SystemConfig> list = query.list();	
		s.close();
		return list;
		
	}

	public void addSystemConfig(SystemConfig systemConfig) {
		// save(systemConfig);
	}

	public List getAllowIp() {
		// TODO Auto-generated method stub
		return null;
	}

}
