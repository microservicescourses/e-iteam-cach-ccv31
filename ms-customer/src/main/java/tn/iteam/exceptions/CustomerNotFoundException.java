package tn.iteam.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String resName , String fieldName , String fieldValue) {

        super(String.format("%s not found for %s and value %s",resName,fieldName,fieldValue));
    }
}