package codeacademy.agne.loans.controlers;

import codeacademy.agne.loans.domain.LoanRecord;
import codeacademy.agne.loans.domain.LoanTableRecord;
import codeacademy.agne.loans.domain.User;
import codeacademy.agne.loans.repository.LoanRecordRepository;
import codeacademy.agne.loans.repository.LoanTableRecordRep;
import codeacademy.agne.loans.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminSiteController {

    @Autowired
    LoanRecordRepository loanRecordRepository;

    @Autowired
    LoanTableRecordRep loanTableRecordRep;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/admin/admin-site")
    public String adminSiteView(Model model){
        return "adminInfo";
    }
    @GetMapping("/admin/admin-info")
    public String adminSiteViewLogin(Model model){
        return "redirect:/admin/admin-site";
    }

    @RequestMapping("/admin/user-list")
    public String allUsersList(Model model) {

        List<User> userList = userRepository.findAll();
        model.addAttribute("userList", userList);
        return "userList";
    }

    @RequestMapping("/admin/user-info")
    public String userInfoAllLoans(@RequestParam("getUsername") String username, Model model) {
        User user = userRepository.findByUsername(username);
        List<LoanRecord> loanRecords = loanRecordRepository.findByUser(user);
        model.addAttribute("loanRecords", loanRecords);
        return "adminUserInfo";
    }

    @GetMapping("/admin/user-disable")
    public String disableUser(@RequestParam("getUsername") String username, Model model) {
        User user = userRepository.findByUsername(username);
        user.setEnabled(false);
        userRepository.save(user);
        model.addAttribute("disabled", "User disabled!");
        return "forward://admin/user-list";
    }

    @GetMapping("/admin/remove-user")
    public String removeUser(@RequestParam("getUsername") String username, Model model) {
        User user = userRepository.findByUsername(username);
        userRepository.delete(user);
        model.addAttribute("removed", "User removed!");
        return "forward:/admin/user-list";
    }


    @GetMapping("/admin/loan-table")
    public String getLoanRecordTable(@RequestParam("getId") int id, Model model) {
        LoanRecord loanRecord = loanRecordRepository.getLoanById(id);
        List<LoanTableRecord> records = loanTableRecordRep.findByLoanRecord(loanRecord);
        model.addAttribute("loanTableRecords", records);
        return "adminInfoTable";
    }

    @GetMapping("/admin/delete/{id}")
    public String removeLoanRecordById(@PathVariable("id") int id) {

        loanRecordRepository.deleteById(id);

        return "redirect:/admin/user-list";
    }

    @GetMapping("/admin/delete-table/{id}")
    public String removeLoanRecordByLoanRecord(@PathVariable("loanTableRecord") LoanTableRecord loanTableRecord) {

        LoanRecord loanRecord = (LoanRecord) loanTableRecordRep.findByLoanRecord(loanTableRecord.getLoanRecord());
        loanRecordRepository.delete(loanRecord);

        return "redirect:/admin/user-list";
    }
}
