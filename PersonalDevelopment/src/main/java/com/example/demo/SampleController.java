package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.UsersInterface;
import com.example.demo.data.UsersService;
import com.example.demo.model.Users;



@RestController

public class SampleController {
	@Autowired
	UsersService service;
	
	@GetMapping("/users")
	@CrossOrigin
	public List<? extends UsersInterface> users() {
		System.out.println("users/index");
		return service.getAll();
	}
	

	@PostMapping("/users/add")
	@CrossOrigin
	public int add(@RequestBody Users users) {
		System.out.println("users/add(post)");
		return service.add(users);
	}
	
	@DeleteMapping("/users/{username}")
    @CrossOrigin
	public void delete(@PathVariable String username) {
        System.out.println("users/delete(delete)");
        service.deleteByUsername(username); 
    }
	 
	@PostMapping("/users/login")
	@CrossOrigin
	public List<Users> findByUsernameAndPassword(@RequestBody UserCredentials credentials) {
	    String username = credentials.getUsername();
	    String password = credentials.getPassword();
	    System.out.println("Service: findByUsernameAndPassword [username=" + username + ", password=" + password + "]");
	    return service.findByUsernameAndPassword(username, password);
	}


	
	
}
