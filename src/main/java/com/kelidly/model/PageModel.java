package com.kelidly.model;

import java.util.List;

public class PageModel {

	public final static String PAGE_MODEL_ATTR="pagemodel";
	private List result;  //显示的记录集
	private int allCount;  // 总记录数
	private int currentPage;
	private int pageSize;  //每页显示的页
	
	
	public int getAllPage() {
		return (this.allCount - 1) / this.pageSize + 1;
	}
	
	public List getResult() {
		return result;
	}
	public void setResult(List result) {
		this.result = result;
	}
	public int getAllCount() {
		return allCount;
	}
	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
}
