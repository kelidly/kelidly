package com.kelidly.service;

import java.util.List;

import com.kelidly.entity.Site;
import com.kelidly.model.tree.SiteTree;

public interface SiteService {

	SiteTree findSiteTree();

	Site findSiteById(long id);

	Site findSiteByCode(String name);

	void modifySite(Site site);

	void addSite(Site site);

	boolean delSite(long id);

	boolean checkSiteName(String name);
	


	List<Site> findFirstSiteList();
	
	List<Site> findSecondListSiteList();

	List<Site> findSiteListByPid(long pid);



	
}
