package com.example.demo.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
import com.example.demo.repositories.UsersRepositry;

import jakarta.transaction.Transactional;

@Service
public class UsersService {
	@Autowired
	private UsersRepositry repository;
	
	@Transactional
    public void deleteByUsername(String username) {
        System.out.println("Service:deleteByUsername:[" + username + "]");
        repository.deleteByUsername(username);
    }
	
	public List<? extends UsersInterface> getAll() {
		System.out.println("Service:getAll");
		return repository.findAll();
	}
	
	
	public List<Users> findByUsernameAndPassword(String username, String password) {
        System.out.println("Service: findByUsernameAndPassword [username=" + username + ", password=" + password + "]");
        return repository.findByUsernameAndPassword(username, password);
    }
	
	
	/**
	 * 
	 * @param item
	 * @return 保存されたエンティティのID、成功しない場合0
	 */
	public int add(UsersInterface item) {
		System.out.println("Service:add [" + item + "]");
		if (item instanceof Users) {
			Users savedItem = repository.saveAndFlush((Users)item);
			return savedItem.getId();
		}
		return 0;
	}
	
	public void delete(UsersInterface item) {
		System.out.println("Service:delete[" + item + "]");
		if (item instanceof Users) {
			repository.delete((Users) item);
		}
	}

}


