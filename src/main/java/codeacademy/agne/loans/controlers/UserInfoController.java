package codeacademy.agne.loans.controlers;

import codeacademy.agne.loans.domain.LoanRecord;
import codeacademy.agne.loans.domain.LoanTableRecord;
import codeacademy.agne.loans.domain.User;
import codeacademy.agne.loans.repository.LoanRecordRepository;
import codeacademy.agne.loans.repository.LoanTableRecordRep;
import codeacademy.agne.loans.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;

@Controller
public class UserInfoController {


    @Autowired
    LoanRecordRepository loanRecordRepository;

    @Autowired
    LoanTableRecordRep loanTableRecordRep;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/user/user-info")
    public String userInfoAllLoans(Model model) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);
        List<LoanRecord> loanRecords = loanRecordRepository.findByUser(user);
        model.addAttribute("loanRecords", loanRecords);
        return "userInfo";
    }

    @GetMapping("/user/loan-table")
    public String getLoanRecordTable(@RequestParam("getId") int id, Model model) {
        LoanRecord loanRecord = loanRecordRepository.getLoanById(id);
        List<LoanTableRecord> records = loanTableRecordRep.findByLoanRecord(loanRecord);
        records.stream()
                .sorted(Comparator.comparingInt(LoanTableRecord::getMonthNr));
        model.addAttribute("loanTableRecords", records);
        return "userInfoTable";
    }







}
