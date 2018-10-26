package com.example.sbo.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.sbo.domain.Role;
import com.example.sbo.domain.UserDetails;
import com.example.sbo.repository.UserDetailsRepository;

@Component
public class CustomUserDetails implements UserDetailsService {

	@Autowired
	private UserDetailsRepository userRepository;

	@Override
	@Transactional
	public UserModel loadUserByUsername(String username) throws UsernameNotFoundException {

		if(userRepository.count()==0)
			userRepository.save(saveUser());
		
		UserDetails user = userRepository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password !");
		}

		Collection<GrantedAuthority> grantedAuthority = new ArrayList<>();
		
		user.getRoles().forEach(role->grantedAuthority.add(new SimpleGrantedAuthority(role.getRoleName().toUpperCase())));

		return new UserModel(user.getUsername(), user.getPassword(), user.isEnabled(), !user.isExpired(), 
				!user.isCredentialexpired(), !user.isLocked(), grantedAuthority);

	}

	private UserDetails saveUser() {
		UserDetails user = new UserDetails();
		user.setUsername("user");
		user.setPassword("user");
		List<Role> roles = new ArrayList<>();
		roles.add(new Role("USER"));
		roles.add(new Role("ACTUATOR"));
		user.setRoles(roles);
		return user;
	}

}
