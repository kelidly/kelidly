package com.kelidly.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.kelidly.dao.LinksDao;
import com.kelidly.entity.Links;
import com.kelidly.model.PageModel;
import com.kelidly.service.LinksService;

@Component("linksService")
public class LinksServiceImpl implements LinksService {

	@Resource(name="linksDao")
	LinksDao linksDao;
	public PageModel query(int pageNo, int pageSize) {
		return linksDao.query(pageNo, pageSize);
	}

	public boolean delete(int id) {
		
		try {
			linksDao.delete(Links.class,id);
		} catch (Exception e) {
			return false;
		}
		
		return true;
		
		
	}

	public boolean update(Links bean) {
		
		try {
			linksDao.update(bean);
		} catch (Exception e) {
			return false;
		}		
		return true;
	}

	public boolean add(Links bean) {
		try {
			linksDao.create(bean);
		} catch (Exception e) {
			return false;
		}		
		return true;
	}

	public Links queryBean(int id) {
		return linksDao.queryBean(id);
	}

	public boolean delete(int[] idArr) {
		return linksDao.delete(idArr);
	}

}
