package com.example.springboot.appDemoLearningSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class CurrencyConfigurationController {
	private static final Logger logger=LoggerFactory.getLogger(CurrencyConfigurationController.class);
	@Autowired
	private CurrencyServiceConfiguration configuration;
	
	@RequestMapping("/currency-configuration")
	public CurrencyServiceConfiguration retrieveAllCourse(){
		logger.info("user name:"+configuration.getUsername());
		return configuration;
	}
	

}
