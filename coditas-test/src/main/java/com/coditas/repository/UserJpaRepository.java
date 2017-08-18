package com.coditas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coditas.data.entity.UserEntity;

public interface UserJpaRepository extends JpaRepository<UserEntity, Integer> {
	
	UserEntity findByName(String loginId);
	
	UserEntity findByEmail(String loginId);
}
