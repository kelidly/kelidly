package com.kelidly.service;

import com.kelidly.entity.Case;
import com.kelidly.model.PageModel;

public interface CaseService {

	PageModel query(int pageNo, int pageSize);

	boolean delete(int id);

	boolean update(Case bean);

	boolean add(Case bean);

	Case queryBean(int id);

	boolean delete(int[] idArr);
}
