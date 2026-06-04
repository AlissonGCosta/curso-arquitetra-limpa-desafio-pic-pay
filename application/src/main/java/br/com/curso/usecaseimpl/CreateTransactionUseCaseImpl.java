package br.com.curso.usecaseimpl;

import br.com.curso.core.domain.Transaction;
import br.com.curso.core.exception.TrasnferException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.gateway.CreateTransactionGateway;
import br.com.curso.usecase.CreateTransactionUseCase;

public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {

    private CreateTransactionGateway createTransactionGateway;
    public CreateTransactionUseCaseImpl(CreateTransactionGateway createTransactionGateway) {
        this.createTransactionGateway = createTransactionGateway;
    }

    @Override
    public Transaction create(Transaction transaction) {

        var transactionSaved =  createTransactionGateway.create(transaction);

        if(transactionSaved == null){
            throw new TrasnferException(ErrorCodeEnum.TR0003.getMessage(),  ErrorCodeEnum.TR0003.getCode());
        }

        return transactionSaved;
    }
}
