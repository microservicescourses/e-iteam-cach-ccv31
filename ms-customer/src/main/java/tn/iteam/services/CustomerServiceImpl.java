package tn.iteam.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.iteam.dto.CustomerDto;
import tn.iteam.entities.Customer;
import tn.iteam.exceptions.CustomerAlreadyExistException;
import tn.iteam.exceptions.CustomerNotFoundException;
import tn.iteam.mappers.CustomerMapper;
import tn.iteam.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    // appels couche repo

    private final CustomerRepository customerRepository;
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerDto getCustomerById(Long id) {

        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Customer", "customerId", id.toString())
        );
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        return customerDto;
    }

    @Override
    public CustomerDto getCustmerByMobile(String mobileNumber) {

        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new CustomerNotFoundException("Customer", "customerId", mobileNumber)
        );
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        return customerDto;
    }

    @Override
    public void saveCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistException("Customer", "mobileNumber", customerDto.getMobileNumber());
        }
        customerRepository.save(customer);

    }
}
