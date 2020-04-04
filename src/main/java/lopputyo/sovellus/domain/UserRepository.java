package lopputyo.sovellus.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	//etsi käyttäjätietokannasta usernamen avulla
	User findByUsername(String username);
}
