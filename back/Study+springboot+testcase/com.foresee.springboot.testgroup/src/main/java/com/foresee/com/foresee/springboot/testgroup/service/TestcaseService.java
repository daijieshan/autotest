package com.foresee.com.foresee.springboot.testgroup.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foresee.com.foresee.springboot.testgroup.mapper.TestcaseMapper;
import com.foresee.com.foresee.springboot.testgroup.mapper.ModelMapper;
import com.foresee.com.foresee.springboot.testgroup.mapper.ProjectMapper;
import com.foresee.com.foresee.springboot.testgroup.dto.Model;
import com.foresee.com.foresee.springboot.testgroup.dto.Project;
import com.foresee.com.foresee.springboot.testgroup.dto.Testcase;

@Service("TestcaseService")
public class TestcaseService {
	@Autowired
	public  TestcaseMapper TestcaseMapper;
	@Autowired
	public  ModelMapper  ModelMapper;
	

	
	public  List  selectCaseBySearch(Testcase record){
		return	TestcaseMapper.selectCaseBySearch(record);
		}
	
	public  int  deleteCaseByCaseid(String testcaseId){
		return	TestcaseMapper.deleteCaseByCaseid(testcaseId);
		}
	public  int  updateCaseByCaseid(Testcase record){
		return	TestcaseMapper.updateCaseByCaseid(record);
		}
	public  int  insertTestcase(Testcase record){
		return	TestcaseMapper.insertTestcase(record);
		}
	
	
	public  int  countCase(Testcase record){
		return	TestcaseMapper.countCase(record);
		}
	
	/*public  List  selectALLProject(Project record){
		return	ProjectMapper.selectALLProject(record);
		}
		*/
}
