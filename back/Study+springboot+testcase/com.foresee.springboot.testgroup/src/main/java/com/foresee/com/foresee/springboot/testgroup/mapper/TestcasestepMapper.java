package com.foresee.com.foresee.springboot.testgroup.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.foresee.com.foresee.springboot.testgroup.dto.TestcaseStep;

@Mapper
public interface TestcasestepMapper {
    List<TestcaseStep> selectStepByCaseId(TestcaseStep record);
    int deleteStepById(String q);
    int insertStepBycaseId(TestcaseStep record);
}
