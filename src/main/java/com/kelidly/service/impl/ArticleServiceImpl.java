package com.kelidly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.kelidly.dao.ArticleDao;
import com.kelidly.entity.Article;
import com.kelidly.model.PageModel;
import com.kelidly.service.ArticleService;
import com.kelidly.service.SiteService;

@Component("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Resource(name="articleDao")
	ArticleDao articleDao;
	@Resource(name="siteService")
	SiteService siteService;


	@Override
	public List<Article> findAllArticle() {

		return articleDao.getAllArticle();
	}
	
	@Override
	public List<Article> findAllProductArticle() {

		return articleDao.getAllProductArticle();
	}

	@Override
	public Article findArticleByid(long id) {

		return articleDao.getArticleByid(id);
	}

	@Override
	public boolean addArticle(Article article) {
		try {
			articleDao.create(article);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	@Override
	public PageModel findArticleByPage(int pageNo, int pageSize) {
		return articleDao.getArticlebypage(pageNo, pageSize);
	}
	@Override
	public boolean deleteArticle(int id) {
		
		try {
			articleDao.delete(Article.class, (long)id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateArticle(Article article) {
		
		try {
			articleDao.update(article);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public PageModel findPageArticleBySiteId(int pageNo, int pageSize, long siteid){
		return articleDao.getPageArticleBySiteId(pageNo, pageSize, siteid);
	}
	
	@Override
	public List<Article> getArticleByLimit(List<Integer> a, int i) {
		
		List<Article> articleList = articleDao.getArticleByLimit(a, i);
		return articleList;
	}



	

}
