package com.foresee.com.foresee.springboot.testgroup.contro;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.foresee.com.foresee.springboot.testgroup.dto.Model;
import com.foresee.com.foresee.springboot.testgroup.dto.Project;
import com.foresee.com.foresee.springboot.testgroup.service.ModelService;


@RestController
@RequestMapping({"/Model"})
public class ModelContrl {
	
	@Resource
	ModelService ModelService;
	
	@RequestMapping(value = "/selModelByProId")
	@ResponseBody
	public Object selModelByProId(@RequestBody Model repro ){
		List<Model>  listpro1 = ModelService.selModelByProId(repro);
		return listpro1 ;
	}
	
	@RequestMapping(value ="/insertModelByProid")
	@ResponseBody
	public Object insertModelByProid(@RequestBody Model repro ){
		repro.setModelId(UUID.randomUUID().toString().replaceAll("-", ""));
		return  ModelService.insertModelByProid(repro);
		
	}
	

	@RequestMapping(value ="/deleteModel")
	@ResponseBody
	public Object deleteModel(@RequestBody Model repro ){
		return ModelService.deleteModel(repro);
	}
	
	
}