package com.jwt.JwtAuthentication.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.JwtAuthentication.model.UserDetailEntity;
import com.jwt.JwtAuthentication.repository.Authentication;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private Authentication  authentication;
	

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		UserDetailEntity userDetail= authentication.getUserCredentialByUsername(userName);
		
		System.out.println(userDetail.getUserName());
		System.out.println(userDetail.getPassword());
		
		if(userName.equals("Vivek")) {
			return new User("Vivek", "Vivek23@", new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("User Not Found");
		}
		
		
	}
}
