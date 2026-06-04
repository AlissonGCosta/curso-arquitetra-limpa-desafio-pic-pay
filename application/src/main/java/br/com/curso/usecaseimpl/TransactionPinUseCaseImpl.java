package br.com.curso.usecaseimpl;

import br.com.curso.core.domain.TransactionPin;
import br.com.curso.gateway.CreateTransactionPinGateway;
import br.com.curso.usecase.CreateTransactionPinUseCase;

public class TransactionPinUseCaseImpl implements CreateTransactionPinUseCase {

    private CreateTransactionPinGateway createTransactionPinGateway;

    public TransactionPinUseCaseImpl(CreateTransactionPinGateway createTransactionPinGateway) {
        this.createTransactionPinGateway = createTransactionPinGateway;
    }

    @Override
    public void create(TransactionPin transactionPin) {
        createTransactionPinGateway.create(transactionPin);

    }
}
