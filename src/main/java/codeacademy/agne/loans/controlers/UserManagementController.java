package codeacademy.agne.loans.controlers;

import codeacademy.agne.loans.domain.User;
import codeacademy.agne.loans.domain.Role;
import codeacademy.agne.loans.repository.UserRepository;
import codeacademy.agne.loans.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserManagementController {

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/")
    public String userManagement(Model model) {

        model.addAttribute("User", new User());

        return "index";
    }

    @GetMapping("/user")
    public String userHomePage(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("hello", "Welcome, " + username + "!");
        return "userHome";
    }

    @GetMapping("/create-user")
    public String createUser(Model model) {

        model.addAttribute("User", new User());

        return "createUser";
    }

    @GetMapping("/admin/create-admin")
    public String createAdmin(Model model) {

        model.addAttribute("User", new User());

        return "createUser";
    }

    @PostMapping("/create-user")
    public String createUser(Model model, @ModelAttribute("User") User user) {

        user.setPassword(encoder.encode(user.getPassword()));
        Role role = new Role();
        role.setAuthority("ROLE_USER");
        role.setUser(user);
        role.setUsername(user.getUsername());
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        user.setEnabled(true);
        userRepository.save(user);
        return "index";
    }

    @PostMapping("/admin/create-admin")
    public String createAdmin(Model model, @ModelAttribute("User") User user) {

        user.setPassword(encoder.encode(user.getPassword()));
        Role role2 = new Role();
        Role role = new Role();
        role.setAuthority("ROLE_ADMIN");
        role.setUser(user);
        role.setUsername(user.getUsername());
        role2.setAuthority("ROLE_USER");
        role2.setUser(user);
        role2.setUsername(user.getUsername());
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        roles.add(role2);
        user.setRoles(roles);
        user.setEnabled(true);
        userRepository.save(user);
        return "adminInfo";
    }

//    @PostMapping("/login")
//    public String loginUser(Model model){
//
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        model.addAttribute("hello", "Welcome, " + username + "!");
//
//        return "userHome";
//    }

}
