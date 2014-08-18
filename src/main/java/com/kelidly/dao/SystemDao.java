package com.kelidly.dao;

import java.util.List;

import com.kelidly.entity.SystemConfig;


public interface SystemDao extends BaseDao<SystemConfig>{
	public List getsystem();
	
	/**
	 * 更新SystemConfig信息
	 * @param list
	 * 
	 */
	public void updateSystemById(List<SystemConfig> list);
	
	
	/**
	 * 根据模块获取系统设置
	 * @param i
	 * @return
	 */
	public List getSystemListBySytle(int i);
	
	public void addSystemConfig(SystemConfig systemConfig);
	
	public List getAllowIp();
}
