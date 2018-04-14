package com.light.web.util;

import java.util.List;

/**
 * @ClassName: JqGridPage
 * @Description: JqGrid分页对象
 */
@SuppressWarnings("rawtypes")
public class JqGridPage {

	private long total;// 总共多少页
	
	private Integer page;// 当前页
	
	private Integer records;// 总共多少条数据
	
	private List rows;// 当前页显示的数据

	public long getTotal() {
		return total;
	}

	/**
	 * 总共多少页
	 * @param total
	 */
	public void setTotal(long total) {
		this.total = total;
	}

	public Integer getPage() {
		return page;
	}

	/**
	 * 当前页
	 * @param page
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRecords() {
		return records;
	}

	/**
	 * 总共多少条数据
	 * @param records
	 */
	public void setRecords(Integer records) {
		this.records = records;
	}

	public List getRows() {
		return rows;
	}

	/**
	 * 当前页显示的数据
	 * @param rows
	 */
	public void setRows(List rows) {
		this.rows = rows;
	}
}
