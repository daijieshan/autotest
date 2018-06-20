package com.foresee.com.foresee.springboot.testgroup.contro;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.foresee.com.foresee.springboot.testgroup.dto.Project;
import com.foresee.com.foresee.springboot.testgroup.service.ProjectService;

@RestController
@RequestMapping({"/home1"})
public class ProjectContrl {
	
	@Resource
	ProjectService ProjectService;
	
	@RequestMapping(value = "/selectALLProject")
	@ResponseBody
	public Object selectALLProject(@RequestBody Project repro ){
		List<Project>  listpro = ProjectService.selectALLProject(repro);
		return listpro ;
	}
     
	@RequestMapping(value = "/selectProjectByProjectparId")
	@ResponseBody
	public Object selectProjectByProjectparId(@RequestBody Project repro ){
		List<Project>  listpro1 = ProjectService.selectProjectByProjectparId(repro);
		return listpro1 ;
	}
	
}
