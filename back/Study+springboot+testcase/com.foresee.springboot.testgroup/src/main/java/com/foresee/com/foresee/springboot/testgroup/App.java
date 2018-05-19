package com.foresee.com.foresee.springboot.testgroup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages= {"com.foresee.com.foresee.springboot.testgroup.dto","com.foresee.com.foresee.springboot.testgroup.mapper",
		"com.foresee.com.foresee.springboot.testgroup.service","com.foresee.com.foresee.springboot.testgroup.contro"})
public class App 
{   
	
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}
