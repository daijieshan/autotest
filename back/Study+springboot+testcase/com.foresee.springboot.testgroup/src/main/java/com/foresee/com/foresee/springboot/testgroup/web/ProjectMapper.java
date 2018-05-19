package com.foresee.com.foresee.springboot.testgroup.web;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

public interface ProjectMapper {
	@Select("select project_id as projectId,project_name as projectName,parent_project_id as parentProjectId,"
			+ "IF((SELECT COUNT(*) FROM project t1 WHERE t1.parent_project_id = t2.project_id)>0,TRUE,FALSE) AS hasChild"
			+ " from project t2 where t2.parent_project_id = #{parentProjectId}")
	public	List<Project>  selectProjectByProjectparId(@Param("parentProjectId")String parentProjectId);
		
	@Select("select model_id as modelId,model_name as modelName from model  where project_id = #{projectId}")
	public	List<Model>  selectModelByProjectId(@Param("projectId")String projectId);
	
	@Select("select testcase_id as testcaseId,testcase_name as testcaseName,catalog as catalog from testcase where model_id = #{modelId} and catalog=#{catalog} ")
	public	List<Testcase>  selectAllCaseByModelId(@Param("modelId")String modelId,@Param("catalog")String catalog);
	//public	List<Testcase>  selectAllCaseByModelId(String modelId,String catalog);  ----不能这样，需指定param
	
	
	
	@Select("select step_name as stepName,tag_name as tagName,attribute_name as attributeName,attribute_value AS attributeValue,"
			+ "operation_method as operationMethod,operation_value as operationValue"
			+ " from 1=1 and  testcase_step where testcase_id = #{testcaseId}")
	public	List<TestcaseStep> selectAllStepByTestcaseId(@Param("testcaseId")String testcaseId);
	
	
	@Insert("insert into testcase (testcase_id,testcase_name,model_id) values "
			+ "( #{testcaseId},#{testcaseName},#{modelId})")
	public int insertTestcase(Testcase testcase);
	
	@Delete("delete from testcase where testcase_id=#{testcaseId}")
	public int deleteCaseByCaseid(@Param("testcaseId")String testcaseId);
	
	@Update("update testcase set testcase_name=#{testcaseName},catalog=#{catalog} where testcase_id=#{testcaseId} ")
	public int updateCaseByCaseid(Testcase testcase);
	

	@Insert("insert into testcase_step (step_id,step_name,testcase_id,tag_name,attribute_name,attribute_value,operation_method,operation_value)"
			+ " values "
			+ "( #{stepId},#{stepName},#{testcaseId},#{tagName},#{attributeName},#{attributeValue},#{operationMethod},#{operationValue})")
	public int insertTeststep(TestcaseStep testcaseStep);
	
	@Delete("delete from testcase_step where step_id= #{stepId}")
	public int deleteTeststepById(@Param("stepId")String stepId);
}
	
	
	

