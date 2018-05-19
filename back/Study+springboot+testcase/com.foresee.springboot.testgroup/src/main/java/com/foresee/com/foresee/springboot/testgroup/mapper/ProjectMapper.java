package com.foresee.com.foresee.springboot.testgroup.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.foresee.com.foresee.springboot.testgroup.dto.Project;


@Mapper
public interface ProjectMapper {
	 List<Project> selectALLProject(Project record);
}
