package com.kelidly.dao.impl;


import java.util.List;

import org.springframework.stereotype.Component;

import com.kelidly.dao.CaseDao;
import com.kelidly.entity.Case;
import com.kelidly.model.PageModel;

@Component("caseDao")
@SuppressWarnings("unchecked")
public class CaseDaoImpl extends ObjectDaoImpl<Case> implements CaseDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//待续
	@Override
	public PageModel query(int pageNo, int pageSize) {
		
		StringBuffer queryHql = new StringBuffer("from Case ");
		StringBuffer countSql = new StringBuffer("select * from cust_case");
//		List<CaseBean> list = query(hql);
		PageModel pageModel = queryPageModel(pageNo,pageSize,queryHql,"",countSql);
		
		return pageModel;
	}

	@Override
	public Case queryBean(int id) {
		
		return (Case)getByPk(Case.class, id);
	}


	@Override
	public boolean delete(int[] idArr) {
//		StringBuffer str = new StringBuffer("delete from cust_case  where id in(");
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

//	public boolean update(Case bean) {
	
//		String pic = bean.getPic();
//		String hql = null;
//		if (pic==null || pic.trim().equals("")) {
//			hql = "update CaseBean set name= '" + bean.getName()
//					+ "',url='" + bean.getUrl() 
//					+ "' where id= " + bean.getId();
//		}else {
//			
//			 hql = "update CaseBean set name= '" + bean.getName()
//					+ "',pic='" + bean.getPic() + "',url='" + bean.getUrl()
//					+ "' where id= " + bean.getId();
//		}
//
//		return update(hql) > 0;
//		return false;
//	}


	

	public List query() {
		// TODO Auto-generated method stub
		return null;
	}




	


}
