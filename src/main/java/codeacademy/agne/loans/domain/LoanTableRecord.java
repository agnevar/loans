package codeacademy.agne.loans.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "loan_record_tables")
@Data
public class LoanTableRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int monthNr;
    private double returnable;
    private double remainder;
    private double addedInterest;
    private double finalSum;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "table_id")
    @ToString.Exclude
    private LoanRecord loanRecord;


}
