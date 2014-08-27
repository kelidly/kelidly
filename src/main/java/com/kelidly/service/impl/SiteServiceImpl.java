package com.kelidly.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.kelidly.dao.SiteDao;
import com.kelidly.entity.Site;
import com.kelidly.model.tree.SiteTree;
import com.kelidly.model.tree.Tree;
import com.kelidly.service.SiteService;

@Component("siteService")
public class SiteServiceImpl  implements SiteService{
 
	
	@Resource(name="siteDao")
	SiteDao siteDao;
	
	@Override
	public SiteTree findSiteTree() {
		List<Site> list=siteDao.getFirstSiteList();
		SiteTree tree=new SiteTree(null, new ArrayList<Tree>());
		for(Site s:list){
			SiteTree secTree=new SiteTree(s,new ArrayList<Tree>());
			List<Site> sublist=siteDao.getSiteListByPid(s.getId());
			for(Site ss:sublist){
				SiteTree subTree=new SiteTree(ss,null);
				secTree.addChild(subTree);
			}
			tree.addChild(secTree);
		}
		return tree;
	}
	
	@Override
	public Site findSiteById(long id) {
		return (Site) siteDao.getByPk(Site.class, id);
	}
	
	@Override
	public Site findSiteByCode(String name) {
		return siteDao.getSiteByName(name);
	}
	
	@Override
	public void modifySite(Site site) {
		siteDao.update(site);
	}
	
	@Override
	public void addSite(Site site) {
		siteDao.create(site);
	}
	
	@Override
	public boolean delSite(long id) {
		try {
			siteDao.delete(Site.class,id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean checkSiteName(String name) {
		Site site  = siteDao.getSiteByName(name);
		if(site==null){
			return true;
		}else{
			return false;
		}
	}

	
	/**
	 * 查找有列表的栏目
	 */
	@Override

	public List<Site> findFirstSiteList() {
		List<Site> sitelist = siteDao.getFirstSiteList();
		return sitelist;
	}
	
	public List<Site> findSecondListSiteList() {
		List<Site> sitelist = siteDao.getSecondListSiteList();

		return sitelist;
	}
	@Override
	public List<Site> findSiteListByPid(long pid) {
		List<Site> sublist=siteDao.getSiteListByPid(pid);
		return sublist;
	}
}
