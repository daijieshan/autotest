package com.foresee.com.foresee.springboot.testgroup.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.foresee.com.foresee.springboot.testgroup.dto.Model;

@Mapper
public interface ModelMapper {
	List<Model> selectModelByproid(Model record);
}
