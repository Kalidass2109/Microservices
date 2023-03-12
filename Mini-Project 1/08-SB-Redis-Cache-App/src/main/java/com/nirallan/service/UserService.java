package com.nirallan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.nirallan.model.User;
import com.nirallan.repository.UserRepo;

@Service
public class UserService {

	@Autowired 
	private UserRepo repo;
	
	public User addUser(User user) {
		User userDetails=new User();
		userDetails.setName(user.getName());
		userDetails.setEmail(user.getEmail());
		return repo.save(user);
	}
	
	@Cacheable(cacheNames="cache1", key="'#key'")
	public List<User> getAllUser() {
		List<User> user=repo.findAll();
		return user;
	}
	
	public java.util.Optional<User> userById(Long id){
		return repo.findById(id);
	}

}
