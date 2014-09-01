package com.kelidly.service;

import java.util.List;

import com.kelidly.entity.Article;
import com.kelidly.entity.ArticleType;
import com.kelidly.entity.NewsType;
import com.kelidly.entity.Site;
import com.kelidly.model.PageModel;
import com.kelidly.model.tree.SiteTree;


public interface ArticleService {

	List<Article> findAllArticle();
	
	List<Article> findAllProductArticle();
	
	Article findArticleByid(long id);
	
	List<ArticleType> findAllArticleType();
	
	boolean updateArticleType(ArticleType articleType);

	boolean deleteArticleType(int id);

	boolean addArticleType(ArticleType articleType);

	boolean addArticle(Article article);

	PageModel findArticlebypage(int pageNo, int pageSize);

	boolean deleteArticle(int id);

	boolean updateArticle(Article article);

	List<Article> findArticleByType(long type);

	PageModel findArticleByPage(int pageNo, int pageSize);

	PageModel findPageArticleBySiteId(int pageNo, int pageSize, long siteid);

	List<Article> getArticleByLimit(List<Integer> a, int i);

	

	
	
	
}
