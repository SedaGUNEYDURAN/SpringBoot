package com.example.springboot.appDemoLearningSpringBoot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@RequestMapping("/courses")
	public List<Course> retrieveAllCourse(){
		return Arrays.asList(
				new Course(1,"Learn AWS","Seda"),
				new Course(2,"Learn Azure","Seda"),
				new Course(3,"Learn DevOps","Seda")
				);
	}
	

}
