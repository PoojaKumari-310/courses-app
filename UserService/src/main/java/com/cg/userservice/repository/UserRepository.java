package com.cg.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.userservice.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	User findByUsername(String username);
}



