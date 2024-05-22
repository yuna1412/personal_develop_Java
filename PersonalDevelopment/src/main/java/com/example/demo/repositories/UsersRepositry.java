package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Users;

@Repository
public interface UsersRepositry extends JpaRepository<Users, Integer> {
	public Optional<Users> findById(int id);
	public List<Users> findByUsername(String key);
	public List<Users> findByUsernameLike(String key);
	public List<Users> deleteByUsername(String key);
	public List<Users> findByUsernameAndPassword(String username, String password);
}