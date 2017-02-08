package com.rockplace.almond.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rockplace.almond.domain.User;
import com.rockplace.almond.repository.UserRepository;
import com.rockplace.almond.repository.UserRoleRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user=userRepository.findByEmail(email);
		if(null == user){
			throw new UsernameNotFoundException("No user present with username: "+email);
		}else{
			return new CustomUserDetails(user);
		}
	}
}