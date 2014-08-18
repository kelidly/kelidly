package com.kelidly.dao;

import com.kelidly.entity.Case;
import com.kelidly.model.PageModel;

public interface CaseDao extends BaseDao<Case>{

	PageModel query(int pageNo, int pageSize);

//	boolean update(Case bean);

	Case queryBean(int id);

	boolean delete(int[] idArr);
}
