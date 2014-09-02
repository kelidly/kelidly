package com.kelidly.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.kelidly.dao.ArticleDao;
import com.kelidly.entity.Article;
import com.kelidly.entity.ArticleType;
import com.kelidly.entity.Site;
import com.kelidly.model.PageModel;


@Component("articleDao") 
@SuppressWarnings("unchecked")
public class ArticleDaoImpl extends ObjectDaoImpl<Article> implements ArticleDao{

	
	private static final long serialVersionUID = 1L;
	
	
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public List<Article> getAllArticle() {

		String hql="from Article";
		
		return super.find(hql);
	}
	
	@Override
	public List<Article> getAllProductArticle() {
		
		String hql="from Article where type= 2";	
		
		return super.find(hql);
	}	
	
	@Override
	public Article getArticleByid(long id) {
		
		String hql="from Article where id= "+id;	
		
		return (Article) super.find(hql).get(0);
	}

	@Override
	public List<ArticleType> getAllArticleType() {
		
		String hql="from ArticleType";	
		
		return super.find(hql);
	}

	@Override
	public PageModel getArticlebypage(int pageNo, int pageSize) {
		
		StringBuffer queryHql = new StringBuffer("from Article");
		StringBuffer countSql = new StringBuffer("select * from Article");
		PageModel pageModel = queryPageModel(pageNo,pageSize,queryHql,"",countSql);		
		
		return pageModel;
	}

	@Override
	public List<Article> getArticleByType(long type) {
		
		String hql="from Article where type= "+type;	
		
		return super.find(hql);
	}

	

	
	@Override
	public PageModel getPageArticleBySiteId(int pageNo, int pageSize, long siteid) {
		StringBuffer queryHql = new StringBuffer("from Article where siteid="+siteid);
		StringBuffer countSql = new StringBuffer("select * from article where siteid="+siteid);
		
		PageModel pageModel = queryPageModel(pageNo,pageSize,queryHql,"",countSql);
		
		return pageModel;
	}
	

	@Override
	public List<Article> getArticleByLimit(List<Integer> a, int i) {

		String hql="from Article where siteid in (:alist) order by addtime desc";  
		Query query = getSession().createQuery(hql);  
		query.setParameterList("alist", a);  
//		query.setInteger("i", i);
		query.setFirstResult(0);
		query.setMaxResults(i);
		List<Article> articleList = query.list();
		return articleList;
	}


	

}
