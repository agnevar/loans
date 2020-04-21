package codeacademy.agne.loans.controlers;

import codeacademy.agne.loans.domain.LoanRecord;
import codeacademy.agne.loans.domain.LoanTableRecord;
import codeacademy.agne.loans.domain.User;
import codeacademy.agne.loans.service.LoanCounting;
import codeacademy.agne.loans.repository.LoanRecordRepository;
import codeacademy.agne.loans.repository.LoanTableRecordRep;
import codeacademy.agne.loans.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class CounterController {

    @Autowired
    LoanRecordRepository loanRecordRepository;

    @Autowired
    LoanTableRecordRep loanTableRecordRep;

    @Autowired
    UserRepository userRepository;

    @Bean
    LoanCounting loanCounting() {
        return new LoanCounting();
    }

    @GetMapping("/user/new-loan")
    public String newLoanManagement(Model model) {

        model.addAttribute("LoanRecord", new LoanRecord());

        return "newLoan";
    }

    @PostMapping("/user/new-loan")
    @Transactional
    public String loanRecordCounting(Model model,
                                     @ModelAttribute("LoanRecord") LoanRecord loanRecord){
        loanRecord.setSum(loanRecord.getSum());
        loanRecord.setTerm(loanRecord.getTerm());
        loanRecord.setLoanPercent(loanRecord.getLoanPercent());
        loanRecord.setAgreementTax(loanRecord.getAgreementTax());
        ArrayList<LoanTableRecord> records = loanCounting().loanTableCounting(loanRecord);
        loanRecord.setTable(records);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);
        loanRecord.setUser(user);
        loanRecordRepository.save(loanRecord);
        for (int i = 0; i < records.size(); i++){
            records.get(i).setLoanRecord(loanRecord);
            loanTableRecordRep.save(records.get(i));
        }

        model.addAttribute("message", "Loan calculated!");
        model.addAttribute("table", "See Table");
        model.addAttribute("id", loanRecord.getId());

        return "newLoan";
    }

}
