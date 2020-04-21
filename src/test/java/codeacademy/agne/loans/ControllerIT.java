package codeacademy.agne.loans;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@ActiveProfiles
public class ControllerIT {

    @Autowired
    private MockMvc mvc;

    @Test
    public void test_homePage_requestMapping() throws Exception {

        mvc.perform(get("/")).andExpect(status().isOk()).andExpect((model().attributeExists("User")))
                .andExpect(forwardedUrl("/WEB-INF/views/index.jsp"));

    }

    @Test
    public void test_user_requestMapping() throws Exception {

        mvc.perform(get("/user")).andExpect(status().is(302)).andExpect(model().attributeExists("hello"))
                .andExpect(forwardedUrl("/WEB-INF/views/userHome.jsp"));

    }

    @Test
    public void test_createUser_requestMapping() throws Exception {
        mvc.perform(get("/create-user")).andExpect(status().isOk()).andExpect(model().attributeExists("User"))
                .andExpect(forwardedUrl("/WEB-INF/views/createUser.jsp"));
    }



}
