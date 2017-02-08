package com.rockplace.almond.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rockplace.almond.domain.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>{
}
