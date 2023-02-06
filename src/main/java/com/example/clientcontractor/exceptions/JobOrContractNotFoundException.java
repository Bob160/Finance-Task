package com.example.clientcontractor.exceptions;

import lombok.Data;

@Data
public class JobOrContractNotFoundException extends RuntimeException{

    private String debugMessage;

    public JobOrContractNotFoundException(String message) {
        super(message);
    }

    public JobOrContractNotFoundException(String message, String debugMessage) {
        super(message);
        this.debugMessage = debugMessage;
    }
}
