package codeacademy.agne.loans.repository.testRepository;

import codeacademy.agne.loans.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestUserRepository extends JpaRepository<User, Integer> {

    public User findByUsername(String username);
}
