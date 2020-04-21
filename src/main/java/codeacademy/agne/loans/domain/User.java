package codeacademy.agne.loans.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true)
    private String username;
    private String password;
    private boolean enabled;
    @OneToMany(mappedBy = "user")
    private List<LoanRecord> loanRecord = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Role> roles = new ArrayList<>();



}
