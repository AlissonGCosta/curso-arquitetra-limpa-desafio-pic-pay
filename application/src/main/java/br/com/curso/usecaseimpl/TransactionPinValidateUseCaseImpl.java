package br.com.curso.usecaseimpl;

import br.com.curso.core.domain.TransactionPin;
import br.com.curso.gateway.TransactionPinValidateGateway;
import br.com.curso.usecase.TransactionPinValidateUseCase;
import br.com.curso.usecase.UpdateTransactionPinUseCase;

public class TransactionPinValidateUseCaseImpl  implements TransactionPinValidateUseCase {

    private TransactionPinValidateGateway transactionPinValidateGateway;
    private UpdateTransactionPinUseCase updateTransactionPinUseCase;

    public TransactionPinValidateUseCaseImpl(TransactionPinValidateGateway transactionPinValidateGateway) {
        this.transactionPinValidateGateway = transactionPinValidateGateway;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin) {
        if(transactionPinValidateGateway.validatePin(transactionPin)){
            return true;
        }
        return false;
    }
}

