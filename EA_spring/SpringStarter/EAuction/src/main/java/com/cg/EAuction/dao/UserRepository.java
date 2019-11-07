package com.cg.EAuction.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.EAuction.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
	public List<User> findByActive(Boolean active);
	
	public User findByUserIdAndActive(Long userId, Boolean active);
	
	public User findByUsernameAndPassAndActive(String username, String pass, Boolean active);
	
	public Optional<User> findByUsername(String username);
	
	public Boolean existsByUsername(String username);
	
	public Boolean existsByEmail(String email);
	
}
