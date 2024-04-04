package com.fonyou.test.shared.model.exception;

public class OperationNotAllowed extends Exception {
    public OperationNotAllowed(String errorMessage) {
        super(errorMessage);
    }
}
