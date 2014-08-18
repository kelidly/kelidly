package com.kelidly.dao;

import com.kelidly.entity.Links;
import com.kelidly.model.PageModel;

public interface LinksDao extends BaseDao<Links>{

	PageModel query(int pageNo, int pageSize);



	Links queryBean(int id);

	boolean delete(int[] idArr);
}
