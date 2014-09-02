package com.kelidly.dao;

import java.util.List;

import com.kelidly.entity.Article;
import com.kelidly.model.PageModel;

public interface ArticleDao extends BaseDao<Article> {

	List<Article> getAllArticle();
	
	List<Article> getAllProductArticle();

	Article getArticleByid(long id);
	
	PageModel getArticlebypage(int pageNo, int pageSize);

	PageModel getPageArticleBySiteId(int pageNo, int pageSize, long siteid);

	List<Article> getArticleByLimit(List<Integer> a, int i);

	

}
