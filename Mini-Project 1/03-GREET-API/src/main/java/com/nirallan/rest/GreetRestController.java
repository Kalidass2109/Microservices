package com.nirallan.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetRestController {
	
	private Logger logger=LoggerFactory.getLogger(GreetRestController.class);
	
	//To know server name which has taken to run the api
	@Autowired
	private Environment env;
	
	@GetMapping("/greet/{name}")
	public String greetMsg(@PathVariable("name") String name) {
		logger.info("greetMsg() execution - start");
		
		String port=env.getProperty("server.port");
		String msg=name+", Good Morning...!! (Server Port :: "+port+ ")";
		logger.info("greetMsg() execution - end");
		return msg;
	}

}
