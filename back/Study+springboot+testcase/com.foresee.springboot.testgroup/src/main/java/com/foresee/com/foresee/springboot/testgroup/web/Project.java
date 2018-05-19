package com.foresee.com.foresee.springboot.testgroup.web;

public class Project {
	private String projectId;
	private String projectName;
	private String parentProjectId;
	private String  hasChild;
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getParentProjectId() {
		return parentProjectId;
	}
	public void setParentProjectId(String parentProjectId) {
		this.parentProjectId = parentProjectId;
	}
	public String getHasChild() {
		return hasChild;
	}
	public void setHasChild(String hasChild) {
		this.hasChild = hasChild;
	}
	
	
}
