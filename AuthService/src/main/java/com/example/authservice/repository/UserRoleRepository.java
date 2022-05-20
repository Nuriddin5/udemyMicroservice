package com.example.authservice.repository;


// t.me/superJavaDeveloper 14.05.2022;


import com.example.authservice.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findByRoleName(String roleName);

    boolean existsByRoleName(String roleName);
}
