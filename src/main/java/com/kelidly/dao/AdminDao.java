package com.kelidly.dao;

import com.kelidly.entity.Admin;

public interface AdminDao extends BaseDao<Admin>{

	
	Admin getAdminByInputNameAndPassword(String userName, String pwd);

}
