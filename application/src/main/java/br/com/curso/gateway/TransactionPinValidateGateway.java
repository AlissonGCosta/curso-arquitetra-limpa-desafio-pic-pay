package br.com.curso.gateway;


import br.com.curso.core.domain.TransactionPin;

public interface TransactionPinValidateGateway {
    boolean validatePin(TransactionPin transactionPin);
}
