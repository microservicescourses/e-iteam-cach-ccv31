package tn.iteam.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class CustomerAlreadyExistException extends RuntimeException {
    public CustomerAlreadyExistException(String resName , String fieldName , String fieldValue) {

        super(String.format("%s already exist for %s and value %s",resName,fieldName,fieldValue));
    }
}