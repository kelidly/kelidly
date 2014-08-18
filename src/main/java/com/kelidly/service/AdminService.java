package com.kelidly.service;

import com.kelidly.entity.Admin;

public interface AdminService {

	public boolean addAdmin(Admin bean);

	public boolean loginAdmin(String userName, String pwd);
}
