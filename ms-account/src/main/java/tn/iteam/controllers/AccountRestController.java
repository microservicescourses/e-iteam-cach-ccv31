package tn.iteam.controllers;


import jakarta.ws.rs.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.iteam.bridges.CustomerClientFeign;
import tn.iteam.entities.Account;
import tn.iteam.models.Customer;
import tn.iteam.services.AccountService;


import java.util.List;

@RestController
public class AccountRestController {
    // Faire appel a la couche service
    @Autowired
    private  AccountService accountService;
    @Autowired
    private CustomerClientFeign customerClientFeign;

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Account getAccountById(@PathVariable String id) {
        Account account = accountService.getAccountById(id);
        // Connect to MS CUSTOMER
        Customer customer = customerClientFeign.getCustomerById(account.getCustomerId());
        account.setCustomer(customer);
        //
        return account;
    }

    @PostMapping("/accounts")
    public void saveCustomer(@RequestBody Account account) {
        accountService.saveAccount(account);
    }
}
