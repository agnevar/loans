package codeacademy.agne.loans.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "loan_records")
@Data
public class LoanRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double sum;
    private int term;
    private int loanPercent;
    private double agreementTax;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loanRecord")
    private List<LoanTableRecord> table = new ArrayList<>();


}
