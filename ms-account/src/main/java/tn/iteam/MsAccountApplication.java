package tn.iteam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import tn.iteam.entities.Account;
import tn.iteam.enums.AccountType;
import tn.iteam.repositories.AccountRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class MsAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsAccountApplication.class, args);
        System.out.println("***MS Account started successfully***");
    }

    // initial data
    @Bean
    public CommandLineRunner commandLineRunner(AccountRepository accountRepository){
        return args -> {

            List<Account> accountList = List.of(
                    Account.builder()
                            .accountId(UUID.randomUUID().toString())
                            .currency("DTN")
                            .balance(Math.random()*90000)
                            .createdAt(LocalDate.now())
                            .type(AccountType.CURRENT_ACCOUNT)
                            .customerId(Long.valueOf(1))
                            .build(),
                    Account.builder()
                            .accountId(UUID.randomUUID().toString())
                            .currency("DTN")
                            .balance(Math.random()*90000)
                            .createdAt(LocalDate.now())
                            .type(AccountType.SAVING_ACCOUNT)
                            .customerId(Long.valueOf(2))
                            .build()

            );

            accountRepository.saveAll(accountList);
        };
    }

}
