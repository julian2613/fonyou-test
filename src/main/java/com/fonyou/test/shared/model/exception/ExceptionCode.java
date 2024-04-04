package com.fonyou.test.shared.model.exception;

public enum ExceptionCode {
    INVALID_REQUEST("Peticion invalida"), OPERATION_NOT_ALLOWED("Operacion no permitida");

    private final String value;

    ExceptionCode(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
