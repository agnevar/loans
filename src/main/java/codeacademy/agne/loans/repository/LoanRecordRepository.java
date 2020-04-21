package codeacademy.agne.loans.repository;

import codeacademy.agne.loans.domain.LoanRecord;
import codeacademy.agne.loans.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRecordRepository extends JpaRepository<LoanRecord, Integer> {
    List<LoanRecord> findByUser(User user);

    LoanRecord getLoanById(int id);

}
