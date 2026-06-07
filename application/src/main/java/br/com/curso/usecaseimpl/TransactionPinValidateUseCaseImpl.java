package br.com.curso.usecaseimpl;

import br.com.curso.core.domain.TransactionPin;
import br.com.curso.core.exception.PinException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.gateway.TransactionPinValidateGateway;
import br.com.curso.usecase.TransactionPinValidateUseCase;
import br.com.curso.usecase.UpdateTransactionPinUseCase;

public class TransactionPinValidateUseCaseImpl  implements TransactionPinValidateUseCase {

    private TransactionPinValidateGateway transactionPinValidateGateway;
    private UpdateTransactionPinUseCase updateTransactionPinUseCase;

    public TransactionPinValidateUseCaseImpl(TransactionPinValidateGateway transactionPinValidateGateway,
                                             UpdateTransactionPinUseCase updateTransactionPinUseCase) {

        this.transactionPinValidateGateway = transactionPinValidateGateway;
        this.updateTransactionPinUseCase = updateTransactionPinUseCase;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin) {
        if(transactionPin.isBlocked()){
                throw new PinException(ErrorCodeEnum.PIN0001.getMessage(), ErrorCodeEnum.PIN0001.getCode());
        }


        if(!transactionPinValidateGateway.validatePin(transactionPin)){
            transactionPin.setAttempt();
            var transactionPinUpdate = updateTransactionPinUseCase.update(transactionPin);
            throw new PinException(ErrorCodeEnum.pin0002GetMessage(transactionPinUpdate.getAttempt()),  ErrorCodeEnum.PIN0002.getCode());
        }

        if(transactionPin.getAttempt()<3){
            transactionPin.restaureAttempt();
            updateTransactionPinUseCase.update(transactionPin);
        }

        return true;
    }
}

