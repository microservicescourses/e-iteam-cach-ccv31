package tn.iteam.services;

import tn.iteam.dto.CustomerDto;
import tn.iteam.entities.Customer;

import java.util.List;

public interface CustomerService {
    // on va mettre logique metier
    List<Customer> getAllCustomers();
    CustomerDto getCustomerById (Long id);
    CustomerDto getCustmerByMobile (String mobileNumber);
    void saveCustomer(CustomerDto customerDto);
}
