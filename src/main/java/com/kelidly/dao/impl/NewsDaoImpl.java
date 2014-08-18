package com.kelidly.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;


//import com.kelidly.framework.orm.basedao.impl.BaseDAOImpl;
//import com.kelidly.hx.dao.impl.BaseDAOImpl;



import com.kelidly.dao.NewsDao;
import com.kelidly.entity.News;
import com.kelidly.entity.NewsType;
import com.kelidly.model.PageModel;


@Component("newsDao") 
@SuppressWarnings("unchecked")
public class NewsDaoImpl extends ObjectDaoImpl<News> implements NewsDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public List queryRecentNews() {
		String hql="from News order by pubTime desc ";		
		return super.query(1, 10, hql);
	}

	@Override
	public List queryByType(int typeId) {
		String hql="from News where typeId= "+typeId;	
		
		return super.find(hql);
	}

	@Override
	public PageModel query(int pageNo, int pageSize, int typeId) {
		StringBuffer queryHql = new StringBuffer("from News where typeId="+typeId);
		StringBuffer countSql = new StringBuffer("select * from news where type_id="+typeId);
		
		PageModel pageModel = queryPageModel(pageNo,pageSize,queryHql,"",countSql);
		
		return pageModel;
	}

	@Override
	public News queryForBeanById(int newsId) {
		return (News) super.getByPk(News.class, newsId);
	}

	@Override
	public List queryForUpDownById(int newsId) {
		// TODO Auto-generated method stub
		return null;
	}	

	@Override
	public PageModel query(int pageNo, int pageSize) {		
		StringBuffer queryHql = new StringBuffer("from News");
		StringBuffer countSql = new StringBuffer("select * from news");
		//List<NewsBean> list = query(hql);
		PageModel pageModel = queryPageModel(pageNo,pageSize,queryHql,"",countSql);
		
		
		return pageModel;
		
	}
	@Override
	public News queryBean(int id) {
		
		return (News)getByPk(News.class, id);
	}


	@Override
	public boolean updateType(NewsType bean) {
//		String hql = "update NewsType set type= '" + bean.getType()
//				+ " 'where id= " + bean.getId();
//
//		return update(hql) > 0;
		return false;
	}
	@Override
	public boolean delete(int[] idArr) {
//		StringBuffer str = new StringBuffer("delete from news  where id in(");
//		for (int i = 0; i < idArr.length; i++) {
//			if(i == idArr.length -1){
//				str.append(idArr[i]+")");
//				break;
//			}
//				str.append(idArr[i]+",");
//		}
//		return executeSql(str.toString());
		return false;
		
	}

	@Override
	public List query() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<NewsType> queryAllType() {
		
		String hql = "from NewsType ";
	
		List<NewsType> list = find(hql);
		return list;
	}


}
