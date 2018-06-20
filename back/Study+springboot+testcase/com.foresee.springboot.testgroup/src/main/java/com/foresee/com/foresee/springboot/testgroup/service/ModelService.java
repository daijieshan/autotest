package com.foresee.com.foresee.springboot.testgroup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foresee.com.foresee.springboot.testgroup.dto.Model;
import com.foresee.com.foresee.springboot.testgroup.dto.Project;
import com.foresee.com.foresee.springboot.testgroup.mapper.ModelMapper;


@Service("ModelService")
public class ModelService {
	@Autowired
	public  ModelMapper     ModelMapper;
	
	public  List  selModelByProId(Model record){
		return	ModelMapper.selModelByProId(record);
		}
	
	public  int  insertModelByProid(Model record){
		return	ModelMapper.insertModelByProid(record);
		}
	
	public  int  deleteModel(Model record){
		return	ModelMapper.deleteModel(record);
		}
	
}
