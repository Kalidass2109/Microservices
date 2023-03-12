package com.nirallan.rest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nirallan.db1.entities.User;
import com.nirallan.db1.repositories.UserRepository;
import com.nirallan.db2.entities.Book;
import com.nirallan.db2.repositories.BookRepository;

@RestController
public class DemoRestController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/data")
	public String addData2DB() {
		userRepository.saveAll(Stream.of(new User(1,"Kali","kali@gmail.com"),
				new User(2,"dass","dass@gamil.com")).collect(Collectors.toList()));
		bookRepository.saveAll(Stream.of(new Book(1,"Core Java",100.00), 
				new Book(2,"Spring Boot",200.00)).collect(Collectors.toList()));
		return "Data Added Successfully";
	}
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/books")
	public List<Book> getBooks(){
		return bookRepository.findAll();
	}

}
