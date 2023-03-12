package com.nirallan.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nirallan.model.User;
import com.nirallan.repository.UserRepo;
import com.nirallan.service.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api")
//@CrossOrigin("http://localhost:3000")
@Api(value="User-Apis",description ="Operation pertaining to user for user details access")
public class UserController {
	
	private static final Logger logger=LogManager.getLogger(UserController.class);
	
	@Autowired
	private UserRepo repository;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(){
		logger.trace("FROM TRACE METHOD");
		logger.warn("FROM WARN METHOD");
		logger.debug("FROM DEBUG METHOD");
		logger.error("FROM ERROR METHOD");
		logger.info("FROM INFO METHOD");
		logger.fatal("FROM FATAL METHOD");
		logger.info("Entered into getAllUsers in UserController class");
		logger.debug("Entered into getAllUsers in UserController class");
		List<User> users=userService.getAllUser();
		if(users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		System.out.println("Controller called"); 
		logger.debug("Leaving from getAllUsers in UserController class");
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Optional<User> > getUserById(long id){
		Optional<User> userById=repository.findById(id);
		return new ResponseEntity<>(userById, HttpStatus.OK);		
	}

	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User user){
		repository.save(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/user/{id} ")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
		Optional<User> userById = repository.findById(id);
		if (userById.isPresent()) {
            User userItem = userById.get();
            userItem.setName(user.getName());
            userItem.setUserName(user.getUserName());
            userItem.setEmail(user.getEmail());
            return new ResponseEntity<>(repository.save(userItem),HttpStatus.OK);
        }else {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}
	
	
}
