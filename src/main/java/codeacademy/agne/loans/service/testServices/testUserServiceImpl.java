package codeacademy.agne.loans.service.testServices;

import codeacademy.agne.loans.domain.User;
import codeacademy.agne.loans.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class testUserServiceImpl implements TestUserService {

    @Autowired
    UserRepository repository;

    @Override
    public User getUser(String mockUsername) {
        return repository.findByUsername(mockUsername);
    }
}
