package com.kelidly.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.kelidly.dao.SiteDao;
import com.kelidly.entity.Site;


@Component("siteDao") 
@SuppressWarnings("unchecked")
public class SiteDaoImpl extends ObjectDaoImpl<Site> implements SiteDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public Site getSiteByName(String name) {
		String sql = "from Site where name=:name";
		Session s = sessionFactory.openSession();
		Query query = s.createQuery(sql);		
		query.setString("name", name);
		List<Site> list = query.list();
		if(list.size()>=1){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	@Override
	public Site getSuperSiteById(long id) {
		return null;	
	}	

	
	@Override
	public List<Site> getSiteListByPid(long pid) {
		String sql = "from Site where pid=:pid order by sort asc";
		Session s = sessionFactory.openSession();
		Query query = s.createQuery(sql);		
		query.setLong("pid", pid);
		List<Site> list = query.list();
		return list;
	}
	
	@Override
	public List<Site> getFirstSiteList() {
		String hql = "from Site where rank=:rank order by sort asc";
		Session s = sessionFactory.openSession();
		Query query = s.createQuery(hql);		
		query.setInteger("rank", 1);
		List<Site> list = query.list();
		return list;
	}

	@Override
	public List<Site> getSecondListSiteList() {
		String hql = "from Site where rank=:rank and state=:state";
		Session s = sessionFactory.openSession();
		Query query = s.createQuery(hql);		
		query.setInteger("rank", 2);
		query.setInteger("state", 2);
		List<Site> list = query.list();
		return list;
	}

	@Override
	public List<Integer> getIdListByPid(long pid) {
		String sql = "select id from Site where pid=:pid and state = 2";
		Session s = sessionFactory.openSession();
		Query query = s.createQuery(sql);		
		query.setLong("pid", pid);
		List<Integer> alist = query.list();
		return alist;
	}

	@Override
	public List<Site> getAllSecondSiteList() {
		
		String hql = "from Site where rank=:rank ";
		Session s = sessionFactory.openSession();
		Query query = s.createQuery(hql);
		query.setInteger("rank", 2);
		List<Site> list = query.list();
		return list;
		
	}
	

}
