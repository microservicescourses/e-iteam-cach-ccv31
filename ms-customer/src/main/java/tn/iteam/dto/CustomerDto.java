package tn.iteam.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CustomerDto {
    @NotEmpty(message = "Name can not be a null or empty")
    @Size(min = 5, max = 15, message = "The length of the customer first name should be between 5 and 15")
    private String firstName;
    @Size(min = 5, max = 15, message = "The length of the customer last name should be between 5 and 15")
    private String lastName;
    @NotEmpty(message = "Email address can not be a null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;
    @Pattern(regexp = "(^$|[0-9]{8})", message = "Mobile number must be 8 digits")
    private String mobileNumber;
    private String environment;
}
 