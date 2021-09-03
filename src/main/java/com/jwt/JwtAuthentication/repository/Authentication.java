package com.jwt.JwtAuthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jwt.JwtAuthentication.model.JwtRequest;
import com.jwt.JwtAuthentication.model.JwtResponse;
import com.jwt.JwtAuthentication.model.UserDetailEntity;


@Repository
public interface Authentication extends JpaRepository<UserDetailEntity, Long>{
	
	@Query(value="select u.* from user_details u where u.username =:username", nativeQuery=true)
	public UserDetailEntity getUserCredentialByUsername(@Param("username") String username); 
}
