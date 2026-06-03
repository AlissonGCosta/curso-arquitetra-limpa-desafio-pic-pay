package br.com.curso.core.exception;

public class TransactionPinExcption extends RuntimeException {
    private String code;
    public TransactionPinExcption(String message, String code) {

        super(message);
        this.code = code;
    }
}
