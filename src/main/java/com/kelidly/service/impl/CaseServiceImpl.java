package com.kelidly.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.kelidly.dao.CaseDao;
import com.kelidly.entity.Case;
import com.kelidly.model.PageModel;
import com.kelidly.service.CaseService;

@Component("caseService")
public class CaseServiceImpl implements CaseService {

	@Resource(name = "caseDao")
	CaseDao caseDao;

	@Override
	public PageModel query(int pageNo, int pageSize) {
		return caseDao.query(pageNo, pageSize);
	}

	@Override
	public boolean delete(int id) {

		try {			
			caseDao.delete(Case.class,id);
		} catch (Exception e) {
			return false;
		}

		return true;
		
	}

	@Override
	public boolean update(Case bean) {
		try {			
			caseDao.update(bean);
		} catch (Exception e) {
			return false;
		}

		return true;
		
		
	}

	@Override
	public boolean add(Case bean) {
		
		try {
			caseDao.create(bean);
		} catch (Exception e) {
			return false;
		}
		
		return true;
		
	}

	@Override
	public Case queryBean(int id) {
		return caseDao.queryBean(id);
	}

	@Override
	public boolean delete(int[] idArr) {
		return caseDao.delete(idArr);
	}

}
