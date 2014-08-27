package com.kelidly.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.kelidly.dao.NewsDao;
import com.kelidly.entity.News;
import com.kelidly.entity.NewsType;
import com.kelidly.model.PageModel;
import com.kelidly.service.NewsService;



@Component("newsService")
public class NewsServiceImpl implements NewsService {

	@Resource(name="newsDao")
	NewsDao newsDao;


	@Override
	public List queryRecentNews() {
		return newsDao.queryRecentNews();
	}

	@Override
	public List queryByType(int typeId) {
		return newsDao.queryByType(typeId);
	}

	@Override
	public List<NewsType> queryAllType() {
		
		return newsDao.queryAllType();
	}

	@Override
	public PageModel query(int pageNo, int pageSize,int typeId) {
		
		return newsDao.query(pageNo,pageSize,typeId);
	}

	@Override
	public News queryForBeanById(int newsId) {
		return newsDao.queryForBeanById(newsId);
	}

	@Override
	public List queryForUpDownById(int newsId) {
		return newsDao.queryForUpDownById(newsId);
	}
	
	@Override
	public PageModel query(int pageNo, int pageSize) {
		
		return newsDao.query(pageNo, pageSize);
	}

	@Override
	public News queryBean(int id) {
		
		return newsDao.queryBean(id);
	}

	@Override
	public boolean delete(int id) {
		try {
			newsDao.delete(News.class, id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean delete(int[] idArr) {
		return newsDao.delete(idArr);
	}

	@Override
	public boolean update(News bean) {		
		try {
			bean.setPubTime(new Date());
			newsDao.update(bean);
		} catch (Exception e) {
			return false;
		}		
		return true;
	}

	@Override
	public boolean add(News bean) {
		
		try {			
			bean.setHot(0);
			bean.setPubTime(new Date());			
			newsDao.create(bean);
		} catch (Exception e) {
			return false;
		}		
		return true;		
	}
	
	@Override
	public boolean addType(NewsType bean) {
		try {
			newsDao.create(bean);
		} catch (Exception e) {
			return false;
		}		
		return true;	
	}

	@Override
	public boolean delType(int typeId) {
		try {
			newsDao.delete(NewsType.class, typeId);
		} catch (Exception e) {
			return false;
		}		
		return true;
		
	}
	
	@Override
	public  boolean updateType(NewsType bean) {		
		try {
			newsDao.update(bean);
		} catch (Exception e) {
			return false;
		}		
		return true;
		
	}

	@Override
	public NewsType findNewstypeByid(int typeid) {
		
		return (NewsType) newsDao.getByPk(NewsType.class, typeid);
	}



}
