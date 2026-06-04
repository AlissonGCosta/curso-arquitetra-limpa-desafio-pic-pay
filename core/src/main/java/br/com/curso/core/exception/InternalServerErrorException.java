package br.com.curso.core.exception;

public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String message, String code) {
        super(message);
    }
}
