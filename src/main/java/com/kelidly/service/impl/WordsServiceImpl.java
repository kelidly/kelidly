package com.kelidly.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.kelidly.dao.WordsDao;
import com.kelidly.entity.Words;
import com.kelidly.model.PageModel;
import com.kelidly.service.WordsService;

@Component("wordsService")
public class WordsServiceImpl implements WordsService {

	@Resource(name="wordsDao")
     WordsDao wordsDao;
	public PageModel query(int pageNo, int pageSize) {
		return wordsDao.query(pageNo, pageSize);
	}

	public boolean delete(int id) {
		try {
			wordsDao.delete(Words.class, id);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

	public boolean update(Words bean) {
		try {
			wordsDao.update(bean);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	

	public Words queryBean(int id) {
		return wordsDao.queryBean(id);
	}

	@Override
	public Boolean saveWords(Words bean) {
		try {
			wordsDao.create(bean);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

}
