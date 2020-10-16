package challenge.security.jwt.repositories;

import challenge.security.jwt.entities.UserIdentity;
import org.springframework.data.repository.CrudRepository;

public interface UserIdentificationRepository extends CrudRepository<UserIdentity, Long> {

	UserIdentity findByUsername(String userName);

}
