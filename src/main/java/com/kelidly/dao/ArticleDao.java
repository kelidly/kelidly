package com.kelidly.dao;

import java.util.List;

import com.kelidly.entity.Article;
import com.kelidly.entity.ArticleType;
import com.kelidly.model.PageModel;

public interface ArticleDao extends BaseDao<Article> {

	List<Article> getAllArticle();
	
	List<Article> getAllProductArticle();

	Article getArticleByid(int id);
	
	List<ArticleType> getAllArticleType();

	PageModel getArticlebypage(int pageNo, int pageSize);

	List<Article> getArticleByType(long type);

	PageModel query(int pageNo, int pageSize);

}
