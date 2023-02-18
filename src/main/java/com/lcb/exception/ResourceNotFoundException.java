package com.lcb.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){

        super(message);}

    public ResourceNotFoundException(String patient, String id, String id1) {

    }
}
