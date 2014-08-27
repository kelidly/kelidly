package com.kelidly.service;

import com.kelidly.entity.Site;
import com.kelidly.model.tree.SiteTree;

public interface SiteService {

	SiteTree getSiteTree();

	Site getSiteById(long id);

	Site getSiteByCode(String name);

	void modifySite(Site site);

	void addSite(Site site);

	boolean delSite(long id);

	boolean checkSiteName(String name);
	
	
}
