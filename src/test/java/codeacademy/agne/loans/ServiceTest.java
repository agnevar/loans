package codeacademy.agne.loans;

import codeacademy.agne.loans.domain.User;
import codeacademy.agne.loans.repository.UserRepository;
import codeacademy.agne.loans.service.testServices.TestUserService;
import codeacademy.agne.loans.service.testServices.testUserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;


@SpringJUnitConfig
class ServiceTest {

	@TestConfiguration
	public static class TestUserServiceImplContextConfiguration {
		@Bean
		public TestUserService testUserService() {
			return new testUserServiceImpl();
		}
	}

	@Autowired
	private TestUserService service;

	@MockBean
	private UserRepository repository;

	@BeforeEach
	public void nustatymai() {
		User mockedUser = new User();
		mockedUser.setUsername("username");
		Mockito.when(repository.findByUsername(mockedUser.getUsername())).thenReturn(mockedUser);
	}

	@Test
	public void jeiguRandameTeisingaProduktoPavadinima() {
		String mockUsername = "username";
		User found = service.getUser(mockUsername);

		assertThat(found.getUsername()).isEqualTo("username");
	}

}
