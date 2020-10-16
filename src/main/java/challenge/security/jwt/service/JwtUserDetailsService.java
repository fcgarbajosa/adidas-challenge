package challenge.security.jwt.service;

import java.util.ArrayList;

import challenge.security.jwt.entities.UserIdentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;


@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserIdentificationService userIdentificationService;
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		UserIdentity user = userIdentificationService.findUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		} else {
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					new ArrayList<>());			
		}
	}
	
	public UserIdentity save(UserIdentity user) {

		return userIdentificationService.save(user);
	}	
}
