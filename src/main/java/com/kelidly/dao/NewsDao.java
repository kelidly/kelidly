package com.kelidly.dao;

import java.util.List;


import com.kelidly.entity.News;
import com.kelidly.entity.NewsType;
import com.kelidly.model.PageModel;

public interface NewsDao extends BaseDao<News>{

	
	List queryRecentNews();
	List queryByType(int typeId);
	List<NewsType> queryAllType();
	PageModel query(int pageNo, int pageSize, int typeId);
	News queryForBeanById(int newsId);
	List queryForUpDownById(int newsId);	
	List query();
	PageModel query(int pageNo, int pageSize);

	boolean updateType(NewsType bean);

//	boolean add(News bean);	

	boolean delete(int[] idArr);

	News queryBean(int id);
}
