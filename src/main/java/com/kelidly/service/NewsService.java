package com.kelidly.service;


import java.util.List;

import com.kelidly.entity.News;
import com.kelidly.entity.NewsType;
import com.kelidly.model.PageModel;


public interface NewsService {


	public List queryByType(int typeId);
	List queryRecentNews();
	public List<NewsType> queryAllType();
	public PageModel query(int pageNo, int pageSize, int typeId);
	public News queryForBeanById(int newsId);
	public List queryForUpDownById(int newsId);
	
	PageModel query(int pageNo, int pageSize);	

	News queryBean(int id);

	boolean delete(int id);

	boolean update(News bean);

	boolean updateType(NewsType bean);

	boolean add(News bean);

	boolean addType(NewsType bean);

	boolean delType(int typeId);

	boolean delete(int[] idArr);
	
	NewsType findNewstypeByid(int typeid);
   
	
	
	
}
