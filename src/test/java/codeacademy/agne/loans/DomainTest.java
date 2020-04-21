package codeacademy.agne.loans;

import codeacademy.agne.loans.domain.User;
import codeacademy.agne.loans.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class DomainTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	UserRepository repository;

	@Test
	public void testFindByUsername() {


		User user = new User();
		user.setUsername("username");
		user.setEnabled(true);
		entityManager.persist(user);
		entityManager.flush();


		User found = repository.findByUsername(user.getUsername());


		assertThat(found.getUsername()).isEqualTo(user.getUsername());

	}

}
