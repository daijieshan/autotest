package com.foresee.com.foresee.springboot.testgroup.web;
//import java.awt.List;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foresee.com.foresee.springboot.testgroup.mapper.TestcaseMapper;


@RestController
@RequestMapping({"/home"})
public class ProjectController {
	
	@Autowired
	ProjectMapper ProMapper;
	
	
/*  第一个测试方法-------
	@RequestMapping(value = "/selectProject")
	@ResponseBody	`
	//public Object user(){
	public String selectByProjectName(String proname) {
		Project pro = ProMapper.selectByProjectName("jchl01");
	return pro.getProjectId()+"-----"+pro.getProjectName();
		//return  pro;
	}
	
	----------*/
	/*请求参数，返回一个类对象
	@RequestMapping(value = "/selectProjectByProjectparId")
	@ResponseBody
	public Object selectProjectByProjectparId(@RequestBody Project repro) {
		Project pro = ProMapper.selectProjectByProjectparId(repro.getParentProjectId());
		return  pro;
	}
	*/
	
	@RequestMapping(value = "/selectProjectByProjectparId")
	@ResponseBody
	public Object selectProjectByProjectparId(@RequestBody Project repro) {
		List<Project>  listpro = ProMapper.selectProjectByProjectparId(repro.getParentProjectId());
		return  listpro;
	}
	
	@RequestMapping(value = "/selectModelByProjectId")
	@ResponseBody
	public Object selectModelByProjectId(@RequestBody Model repro) {
		List<Model>  listpro = ProMapper.selectModelByProjectId(repro.getProjectId());
		return  listpro;
	}
	
	
	
	@RequestMapping(value = "/selectAllCaseBymodelId")
	@ResponseBody
	public Object selectAllCaseByprojectId(@RequestBody Testcase repro ){
		List<Testcase>  listpro = ProMapper.selectAllCaseByModelId(repro.getModelId(),repro.getCatalog());
		return listpro ;
	
	}
     
	
	
	
	@RequestMapping(value = "/selectAllStepByTestcaseId")
	@ResponseBody
	public Object selectAllStepByTestcaseId(@RequestBody TestcaseStep repro ){
		List<TestcaseStep>  listpro = ProMapper.selectAllStepByTestcaseId(repro.getTestcaseId());
		return listpro ;
	
	}
	
	@RequestMapping(value = "/insertTestcase")
	@ResponseBody
	public Object insertTestcase(@RequestBody  Testcase testcase1){
		testcase1.setTestcaseId(UUID.randomUUID().toString().replaceAll("-", ""));
		 return	 ProMapper.insertTestcase(testcase1);
	}
     
	@RequestMapping(value = "/deleteCaseByCaseid")
	@ResponseBody
	public Object deleteCaseByCaseid(@RequestBody Testcase testcase1 ){
		return ProMapper.deleteCaseByCaseid(testcase1.getTestcaseId());
	}
	
	@RequestMapping(value = "/updateCaseByCaseid")
	@ResponseBody
	public Object updateCaseByCaseid(@RequestBody Testcase testcase1 ){
		return ProMapper.updateCaseByCaseid(testcase1);
	}
	
	@RequestMapping(value = "/insertTeststep")
	@ResponseBody
	public Object insertTeststep(@RequestBody TestcaseStep Teststep1){
		Teststep1.setStepId(UUID.randomUUID().toString().replaceAll("-", ""));
		return ProMapper.insertTeststep(Teststep1);	 
	}
	
	
	@RequestMapping(value = "/deleteTeststepById")
	@ResponseBody
	public Object deleteTeststepById(@RequestBody TestcaseStep Teststep1){
		return ProMapper.deleteTeststepById(Teststep1.getStepId());	 
	}
	
	
}
