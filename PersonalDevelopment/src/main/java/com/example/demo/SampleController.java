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

	@GetMapping("/users/{id}")
	@CrossOrigin
	public UsersInterface fruitById(@PathVariable int id) {
		System.out.println("users/findById");
		return service.getById(id);
	}
	
//	@GetMapping("/users/{startId}/{endId}")
//	@CrossOrigin
//	public List<? extends UsersInterface> apartmentsInRange(@PathVariable int startId, @PathVariable int endId) {
//	    System.out.println("users/findInRange");
//	    return service.findApartmentsInRange(startId, endId);
//	}


	@PostMapping("/users/add")
	@CrossOrigin
	public int add(@RequestBody Users users) {
		System.out.println("users/add(post)");
		return service.add(users);
	}

	@PostMapping("/users/update")
	@CrossOrigin
	public int update(@RequestBody Users users) {
		System.out.println("users/update(post)");
		return service.add(users);
	}

//	@PostMapping("/users/delete")
//	@CrossOrigin
//	public void delete(@RequestBody Users users) {
//		System.out.println("users/delete(post)");
//		service.delete(users);
//	}
	
	@DeleteMapping("/users/{username}")
    @CrossOrigin
	public void delete(@PathVariable String username) {
        System.out.println("users/delete(delete)");
        service.deleteByUsername(username); // ユーザー名に基づいてユーザーを削除する処理を呼び出す
    }
	 
	@PostMapping("/users/login")
	public List<Users> findByUsernameAndPassword(String username, String password) {
	    System.out.println("Service: findByUsernameAndPassword [username=" + username + ", password=" + password + "]");
	    return service.findByUsernameAndPassword(username, password);
	}
	
	
}
