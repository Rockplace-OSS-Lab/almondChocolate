package com.rockplace.almond.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rockplace.almond.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByEmail(String email);
}