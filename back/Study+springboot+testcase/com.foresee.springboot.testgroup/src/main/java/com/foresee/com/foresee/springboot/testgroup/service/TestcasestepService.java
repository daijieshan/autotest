package com.foresee.com.foresee.springboot.testgroup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foresee.com.foresee.springboot.testgroup.dto.TestcaseStep;
import com.foresee.com.foresee.springboot.testgroup.mapper.TestcasestepMapper;

@Service("TestcasestepService")
public class TestcasestepService {
    @Autowired
    public TestcasestepMapper stepMapper;
    
    public List selectStepByCaseId(TestcaseStep repro) {
    	return stepMapper.selectStepByCaseId(repro);
    }
    
    public int deleteStepById(String repro) {
    	return stepMapper.deleteStepById(repro);
    }
    
    public int insertStepBycaseId(TestcaseStep repro) {
    	return stepMapper.insertStepBycaseId(repro);
    }
    
}
