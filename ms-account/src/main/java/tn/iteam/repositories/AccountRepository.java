package tn.iteam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.iteam.entities.Account;


public interface AccountRepository extends JpaRepository<Account, String> {

}
