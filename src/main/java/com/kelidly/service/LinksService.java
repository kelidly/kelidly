package com.kelidly.service;

import com.kelidly.entity.Links;
import com.kelidly.model.PageModel;

public interface LinksService {

	PageModel query(int pageNo, int pageSize);

	boolean delete(int id);

	boolean update(Links bean);

	boolean add(Links bean);

	Links queryBean(int id);

	boolean delete(int[] idArr);

}
