package com.kelidly.dao.impl;


import java.util.List;

import org.springframework.stereotype.Component;

import com.kelidly.dao.LinksDao;
import com.kelidly.entity.Links;
import com.kelidly.model.PageModel;


@Component("linksDao")
@SuppressWarnings("unchecked")
public class LinksDaoImpl extends ObjectDaoImpl<Links> implements LinksDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public PageModel query(int pageNo, int pageSize) {
		
		StringBuffer queryHql = new StringBuffer("from Links");
		StringBuffer countSql = new StringBuffer("select * from links");
		//List<LinksBean> list = query(hql);
		PageModel pageModel = queryPageModel(pageNo,pageSize,queryHql,"",countSql);		
		
		return pageModel;
	}

	@Override
	public Links queryBean(int id) {
		
		return (Links)getByPk(Links.class, id);
	}

//	public boolean delete(int id) {
//		
//		try {
//			this.delById(Links.class, id);
//		} catch (Exception e) {
//			return false;
//		}
//		
//		return true;
//	}
//	



	@Override
	public boolean delete(int[] idArr) {
//		StringBuffer str = new StringBuffer("delete from links  where id in(");
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



//	public boolean add(Links bean) {
//		
//		try {
//			saveOrUpdate(bean);
//		} catch (Exception e) {
//			return false;
//		}
//		
//		return true;
//	}
	

	public List query() {
		// TODO Auto-generated method stub
		return null;
	}




	


}
