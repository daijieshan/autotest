package com.foresee.com.foresee.springboot.testgroup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foresee.com.foresee.springboot.testgroup.dto.Project;
import com.foresee.com.foresee.springboot.testgroup.mapper.ProjectMapper;


@Service("ProjectService")
public class ProjectService {
	@Autowired
	public  ProjectMapper   ProjectMapper;
	
	public  List  selectALLProject(Project record){
		return	ProjectMapper.selectALLProject(record);
		}
	
	public  List  selectProjectByProjectparId(Project record){
		return	ProjectMapper.selectProjectByProjectparId(record);
		}
}
