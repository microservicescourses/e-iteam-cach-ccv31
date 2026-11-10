package tn.iteam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.iteam.entities.Customer;
import tn.iteam.repositories.CustomerRepository;

import java.util.List;

@SpringBootApplication
public class MsCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCustomerApplication.class, args);
        System.out.println("########### Ms Customer Application Started ###########");
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            List<Customer> customer = List.of(
                    Customer.builder()
                            .firstName("Iheb")
                            .lastName("Elazheri")
                            .email("iheb@gmail.com")
                            .mobileNumber("12345678")
                            .build(),
                    Customer.builder()
                            .firstName("Dhia")
                            .lastName("Gaied")
                            .email("Dhia@gmail.com")
                            .mobileNumber("837893719")
                            .build()
            );
            customerRepository.saveAll(customer);
        };
    }

}
