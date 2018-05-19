package com.foresee.com.foresee.springboot.testgroup.dto;

import java.sql.Timestamp;

public class Testcase {
	private String testcaseId;
	private String testcaseName;
	private String  modelId;
	private String  catalog;
    private Timestamp  createDate;
    
    private int start;
    private int last;
    private int   pageSize;
    private int  total;
    private int  currentPage;
	
	public String getTestcaseId() {
		return testcaseId;
	}
	public void setTestcaseId(String testcaseId) {
		this.testcaseId = testcaseId;
	}
	public String getTestcaseName() {
		return testcaseName;
	}
	public void setTestcaseName(String testcaseName) {
		this.testcaseName = testcaseName;
	}
	public String getModelId() {
		return modelId;
	}
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	public String getCatalog() {
		return catalog;
	}
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp td) {
	
		this.createDate = td;
	}
	
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		/*if(this.start != null)*/
		this.start = start;
	}
	
	
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		
		this.last = last;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		//this.start = (this.currentPage-1)*pageSize;
	}
     	
	
}
