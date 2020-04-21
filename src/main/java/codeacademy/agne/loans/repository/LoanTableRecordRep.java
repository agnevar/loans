package codeacademy.agne.loans.repository;

import codeacademy.agne.loans.domain.LoanRecord;
import codeacademy.agne.loans.domain.LoanTableRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanTableRecordRep extends JpaRepository<LoanTableRecord, Integer> {

    List<LoanTableRecord> findByLoanRecord(LoanRecord loanRecord);

}
