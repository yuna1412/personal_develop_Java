package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Users;

@Repository
public interface UsersRepositry extends JpaRepository<Users, Integer> {
	public List<Users> findByUsername(String key);
	public List<Users> deleteByUsername(String key);
	public List<Users> findByUsernameAndPassword(String username, String password);
}