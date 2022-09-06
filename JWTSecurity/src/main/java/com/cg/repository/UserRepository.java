package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);
}
