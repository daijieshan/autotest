package com.foresee.com.foresee.springboot.testgroup.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	
	  private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	  
    @GetMapping("/helloworld")
    public String helloworld() {
	   //logger.info("fdsgfghfghfg");
        return "helloworld";
    }
}

