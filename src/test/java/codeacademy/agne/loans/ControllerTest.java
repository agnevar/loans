package codeacademy.agne.loans;

import codeacademy.agne.loans.domain.User;
import codeacademy.agne.loans.repository.UserRepository;
import codeacademy.agne.loans.service.testServices.TestUserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest
class ControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TestUserService service;

    @MockBean
    private UserRepository repository;

    @Test
    public void mvcTest() throws Exception {

        Mockito.when(repository.findByUsername("username")).thenReturn(new User());

        mvc.perform(get("/")).andExpect(status().isOk()).andExpect((model().attributeExists("User"))).andExpect(forwardedUrl("/WEB-INF/views/index.jsp"));

        mvc.perform(get("/user")).andExpect(status().isOk()).andExpect((model().attributeExists("tUser"))).andExpect(forwardedUrl("/WEB-INF/views/index.jsp"));

        User user = new User();
        user.setUsername("username");
        Mockito.when(repository.findByUsername("username")).thenReturn(user);

    }

}

