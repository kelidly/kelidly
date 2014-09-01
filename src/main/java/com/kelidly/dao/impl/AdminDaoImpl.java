package com.kelidly.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.kelidly.dao.AdminDao;
import com.kelidly.entity.Admin;


@Component("adminDao") 
@SuppressWarnings("unchecked")
public class AdminDaoImpl extends ObjectDaoImpl<Admin> implements AdminDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private SessionFactory sessionFactory;	

	@Override
	public Admin getAdminByInputNameAndPassword(String userName, String pwd) {
		
		String hql = "from Admin where adminName=:inputname and password=:password";
		Session s = sessionFactory.openSession();
		Query query = s.createQuery(hql);
		query.setString("inputname", userName);
		query.setString("password", pwd);
		List<Admin> list = query.list();
		if (list != null && list.size() >= 1) {
			return list.get(0);
		} else {
			return null;
		}
	}

}
