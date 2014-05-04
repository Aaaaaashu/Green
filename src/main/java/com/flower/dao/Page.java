package com.flower.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page implements Serializable {
	
	private static int DEFAULT_PAGE_SIZE = 20;
	
	private int pageSize = DEFAULT_PAGE_SIZE;
	
	private long start;
	
	private List data;
	
	private long totalCount;
	
	public Page() {
		this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList());
	}
	
	public Page(long start, long totalCount, int pageSize, List data) {
		this.start = start;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.data = data;
	}
	
	public long getTotalCount() {
		return this.totalCount;
	}
	
	public long getTotalPageCount() {
		if (totalCount % pageSize == 0)
			return totalCount / pageSize;
		else 
			return totalCount / pageSize + 1;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public List getResult() {
		return data;
	}
	
	public long getCurrentPageNo() {
		return start / pageSize + 1;
	}
	
	public boolean isHasNextPage() {
		return this.getCurrentPageNo() < this.getTotalPageCount();
	}
	
	public boolean isHasPreviousPage() {
		return this.getCurrentPageNo() > 1;
	}
	
	protected static int getStartOfPage(int pageNo) {
		return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
	}
	
	public static int getStartOfPage(int pageNo, int pageSize) {
		return (pageNo - 1) * pageSize;
	}
}
