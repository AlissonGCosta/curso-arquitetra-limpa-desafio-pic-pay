package br.com.curso.usecaseimpl;

import br.com.curso.core.domain.Transaction;
import br.com.curso.core.exception.TrasnferException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.gateway.TransictionValidateGateway;
import br.com.curso.gateway.UserNotificationGateway;
import br.com.curso.usecase.TransactionValidateUseCase;

public class TransictionValidateUseCaseImpl implements TransactionValidateUseCase {

    private TransictionValidateGateway transictionValidateGateway;

    public TransictionValidateUseCaseImpl(TransictionValidateGateway transictionValidateGateway) {
        this.transictionValidateGateway = transictionValidateGateway;
    }

    @Override
    public Boolean validateTransaction(Transaction transaction) {
        if(!transictionValidateGateway.validate(transaction)){
            throw new TrasnferException(ErrorCodeEnum.TR0004.getMessage(),  ErrorCodeEnum.TR0004.getCode());
        }

        return true;
    }
}
