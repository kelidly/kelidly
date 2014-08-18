package com.kelidly.dao;

import com.kelidly.entity.Words;
import com.kelidly.model.PageModel;

public interface WordsDao extends BaseDao<Words> {

	PageModel query(int pageNo, int pageSize);

//	boolean delete(int id);

//	boolean update(Words bean);

//	boolean add(Words bean);

	Words queryBean(int id);
}
