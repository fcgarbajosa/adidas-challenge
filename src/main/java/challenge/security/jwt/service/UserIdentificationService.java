package challenge.security.jwt.service;

import challenge.security.jwt.entities.UserIdentity;

public interface UserIdentificationService {
	
	UserIdentity findUserByUsername(String userName);
	public UserIdentity save(UserIdentity user);
}
