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
	
	public UsersInterface getById(int id) {
		System.out.println("Service:getById id[" + id + "]");
		return repository.findById(id).orElse(null);
	}
	
	public List<? extends UsersInterface> findByNameLike(String find) {
		System.out.println("Service:getByNameLike find[" + find + "]");
		return repository.findByUsernameLike("%" + find + "%");
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

//	public void deleteByUsername(String username) {
//	    System.out.println("Service:deleteByUsername:[" + username + "]");
//	    repository.deleteByUsername(username);
//	}


//	public List<? extends UsersInterface> findApartmentsInRange(int startId, int endId) {
//	    System.out.println("Service:findApartmentsInRange startId[" + startId + "] endId[" + endId + "]");
//	    return repository.findApartmentsByIdRange(startId, endId);
//	}

}
