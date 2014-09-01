package com.kelidly.dao.impl;


import java.util.List;

import org.springframework.stereotype.Component;

import com.kelidly.dao.WordsDao;
import com.kelidly.entity.Words;
import com.kelidly.model.PageModel;


@Component("wordsDao")
@SuppressWarnings("unchecked")
public class WordsDaoImpl extends ObjectDaoImpl<Words> implements WordsDao{

	@Override
	public PageModel query(int pageNo, int pageSize) {
		
//		StringBuffer queryHql = new StringBuffer("from WordsBean ");
//		StringBuffer countSql = new StringBuffer("select * from words");
//		//List<WordsBean> list = query(hql);
//		PageModel pageModel = queryPageModel(pageNo,pageSize,queryHql,"",countSql);
		PageModel pageModel = null;
		
		return pageModel;
	}

	@Override
	public Words queryBean(int id) {
		
		return (Words)getByPk(Words.class, id);
	}

//	public boolean delete(int id) {
//		
//		try {
//			this.delById(Words.class, id);
//		} catch (Exception e) {
//			return false;
//		}
//		
//		return true;
//	}
	



	public boolean delete(int[] idArr) {
		StringBuffer str = new StringBuffer("delete from news  where id in(");
		for (int i = 0; i < idArr.length; i++) {
			if(i == idArr.length -1){
				str.append(i+")");
				break;
			}
				str.append(i+",");
		}
		try {
			excuteSql(str.toString());
		} catch (Exception e) {
			return false;
		}
		
		return true;
		
	}

//	public boolean update(Words bean) {
//
//	
///*		String	hql = "update WordsBean set name= '" + bean.getCompany()
//					+ "',url='" + bean.getEmail() 
//					+ "' where id= " + bean.getId();*/
//		String hql="";
//		
//
//		return update(hql) > 0;
//	}

//	public boolean add(Words bean) {
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
