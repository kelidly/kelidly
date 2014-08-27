package com.kelidly.dao;

import java.util.List;

import com.kelidly.entity.Site;

public interface SiteDao extends BaseDao<Site> {

	/**
	 * 根据name查找site栏目对象
	 * @param name
	 * @return
	 */
	Site getSiteByName(String name);
	
	/**
	 * 根据id查找父site栏目对象
	 * @param id
	 * @return
	 */	
	Site getSuperSiteById(long id);	
	
	
	/**
	 * 通过id查找子栏目
	 * @param pid
	 * @return
	 */
	List<Site> getSiteListByPid(long pid);
	
	/**
	 * 查找一级栏目	
	 * @return
	 */
	List<Site> getFirstSiteList();
	/**
	 * 查找二级栏目	
	 * @return
	 */

	List<Site> getSecondListSiteList();
	
	
}
