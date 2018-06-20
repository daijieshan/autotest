package com.foresee.com.foresee.springboot.testgroup.contro;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.foresee.com.foresee.springboot.testgroup.dto.Testcase;
import com.foresee.com.foresee.springboot.testgroup.dto.TestcaseStep;

@RestController
@RequestMapping({"/casestep"})
public class TestcasestepContrl {
     @Resource
     com.foresee.com.foresee.springboot.testgroup.service.TestcasestepService  TestcasestepService;
     
     
     @RequestMapping(value = "/selectStepByCaseId")
 	@ResponseBody
 	public Object selectStepByCaseId(@RequestBody TestcaseStep record ){
 		return TestcasestepService.selectStepByCaseId(record);	
 	}
     
     @RequestMapping(value = "/deleteStepById")
  	@ResponseBody
  	public Object deleteStepById(@RequestBody TestcaseStep record  ){
  		return TestcasestepService.deleteStepById(record.getStepId());	
  	}
     
     @RequestMapping(value = "/insertStepBycaseId")
   	@ResponseBody
   	public Object insertStepBycaseId(@RequestBody TestcaseStep record  ){
    	 record.setStepId(UUID.randomUUID().toString().replaceAll("-", ""));
   		return TestcasestepService.insertStepBycaseId(record);	
   	}
     
     
     
}
