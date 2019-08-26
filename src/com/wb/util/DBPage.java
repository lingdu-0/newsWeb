package com.wb.util;

import java.util.ArrayList;
import java.util.List;

public class DBPage<T> {

	private int totalPageCount = 1;// 总页数
	private int pageSize = 10;// 页面大小，即每页显示记录数
	private int totalCount = 0;// 记录总数
	private int currPageNo = 1;// 当前页码
	List<T> list = new ArrayList<>();// 每页集合

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.totalPageCount = (totalCount % pageSize == 0 ? (totalCount / pageSize) : totalCount / pageSize + 1);
	}

	public int getCurrPageNo() {
		return currPageNo;
	}

	public void setCurrPageNo(int currPageNo) {
		this.currPageNo = currPageNo;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
