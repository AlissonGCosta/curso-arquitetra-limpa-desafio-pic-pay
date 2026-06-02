package br.com.curso.core.exception;

public class TrasnferException extends RuntimeException {

    private String code;

    public TrasnferException(String message, String code) {
        super(message);
        this.code = code;

    }
}
