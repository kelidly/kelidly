package com.kelidly.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.kelidly.dao.ArticleDao;
import com.kelidly.dao.SiteDao;
import com.kelidly.entity.Article;
import com.kelidly.entity.ArticleType;
import com.kelidly.entity.Site;
import com.kelidly.model.PageModel;
import com.kelidly.model.tree.SiteTree;
import com.kelidly.model.tree.Tree;
import com.kelidly.service.ArticleService;

@Component("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Resource(name="articleDao")
	ArticleDao articleDao;
	


	@Override
	public List<Article> findAllArticle() {

		return articleDao.getAllArticle();
	}
	
	@Override
	public List<Article> findAllProductArticle() {

		return articleDao.getAllProductArticle();
	}

	@Override
	public Article findArticleByid(int id) {

		return articleDao.getArticleByid(id);
	}

	@Override
	public List<ArticleType> findAllArticleType() {
		
		return articleDao.getAllArticleType();
	}

	@Override
	public boolean updateArticleType(ArticleType articleType) {
		
		try {
			articleDao.update(articleType);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean deleteArticleType(int id) {
		
		try {
			articleDao.delete(ArticleType.class,(long)id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean addArticleType(ArticleType articleType) {

		try {
			articleDao.create(articleType);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
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
	public PageModel findArticlebypage(int pageNo, int pageSize) {
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
	public List<Article> findArticleByType(long type) {
		
		return articleDao.getArticleByType(type);
	}

	@Override
	public PageModel findArticleByPage(int pageNo, int pageSize) {
		return articleDao.query(pageNo, pageSize);
	}
	

	

	

}
