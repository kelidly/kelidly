package com.kelidly.service;

import com.kelidly.entity.Words;
import com.kelidly.model.PageModel;

public interface WordsService {

	PageModel query(int pageNo, int pageSize);

	boolean delete(int id);

	boolean update(Words bean);

	Words queryBean(int id);

	Boolean saveWords(Words bean);
}
