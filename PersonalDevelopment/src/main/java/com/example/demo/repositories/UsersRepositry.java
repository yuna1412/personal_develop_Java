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
//	@Query("SELECT a FROM Apartment a WHERE a.id BETWEEN :startId AND :endId")
//    List<Users> findApartmentsByIdRange(@Param("startId") int startId, @Param("endId") int endId);
}