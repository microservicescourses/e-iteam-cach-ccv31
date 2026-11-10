package tn.iteam.controllers;


import jakarta.ws.rs.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.iteam.dto.CustomerDto;
import tn.iteam.dto.ResponseDto;
import tn.iteam.entities.Customer;
import tn.iteam.enums.CustomerResponseStatus;
import tn.iteam.services.CustomerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerRestController {
    // Faire appel a la couche service
    private final CustomerService customerService;
    @Autowired
    private Environment environment;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public CustomerDto getCustomerById(@PathVariable(name="id") Long id) {
        CustomerDto customer = customerService.getCustomerById(id);
        String port = environment.getProperty("server.port");
        customer.setEnvironment(port);
        return customer;
    }


    @GetMapping("/customers/fetch")
    public CustomerDto getCustmerByMobile(@PathParam(value="mobileNumber") String mobileNumber) {

        return customerService.getCustmerByMobile(mobileNumber);
    }


    @PostMapping("/customers")
    public ResponseEntity<ResponseDto> saveCustomer(@RequestBody CustomerDto customer) {
        customerService.saveCustomer(customer);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(CustomerResponseStatus.CREATED.getCode(),
                        CustomerResponseStatus.CREATED.getMessage()));
    }
}
