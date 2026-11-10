package tn.iteam.bridges;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.iteam.models.Customer;

@FeignClient(name = "MS-CUSTOMER")
public interface CustomerClientFeign {
    @GetMapping("/customers/{id}")
    Customer getCustomerById(@PathVariable Long id);
}
