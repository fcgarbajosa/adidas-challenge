package challenge.security.jwt.service;

import challenge.security.jwt.entities.UserIdentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import challenge.security.jwt.repositories.UserIdentificationRepository;

@Component
public class UserIdentificationServiceImpl implements UserIdentificationService { 

	  @Autowired 
	  private UserIdentificationRepository userIdentificationRepository;

	  @Autowired
	  private PasswordEncoder bcryptEncoder;

	  public UserIdentity findUserByUsername(String userName) {
		  
		  return userIdentificationRepository.findByUsername(userName);
	  }
	  
	  public UserIdentity save(UserIdentity user) {
			UserIdentity newUser = new UserIdentity();
			newUser.setUsername(user.getUsername());
			newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
			return userIdentificationRepository.save(newUser);
	 }
}
