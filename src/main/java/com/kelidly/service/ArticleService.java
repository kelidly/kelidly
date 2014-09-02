package com.kelidly.service;

import java.util.List;

import com.kelidly.entity.Article;
import com.kelidly.model.PageModel;


public interface ArticleService {

	List<Article> findAllArticle();
	
	List<Article> findAllProductArticle();
	
	Article findArticleByid(long id);
	
	boolean addArticle(Article article);

	boolean deleteArticle(int id);

	boolean updateArticle(Article article);

	PageModel findArticleByPage(int pageNo, int pageSize);

	PageModel findPageArticleBySiteId(int pageNo, int pageSize, long siteid);

	List<Article> getArticleByLimit(List<Integer> a, int i);

	

	
	
	
}
