package almond.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import almond.domain.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>{
}
