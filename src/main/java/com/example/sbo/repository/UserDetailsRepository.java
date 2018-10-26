package com.example.sbo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sbo.domain.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

	UserDetails findByUsername(String username);
	
}
