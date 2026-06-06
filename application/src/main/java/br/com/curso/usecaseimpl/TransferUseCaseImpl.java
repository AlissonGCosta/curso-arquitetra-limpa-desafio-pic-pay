package br.com.curso.usecaseimpl;

import br.com.curso.core.domain.Transaction;
import br.com.curso.core.domain.Wallet;

import br.com.curso.core.exception.InternalServerErrorException;
import br.com.curso.core.exception.NotFoundException;
import br.com.curso.core.exception.NotificationException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.gateway.TransferGateway;
import br.com.curso.usecase.*;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUseCase {

    private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    private TransactionValidateUseCase transactionValidateUseCase;
    private CreateTransactionUseCase createTransactionUseCase;
    private TransferGateway transferGateway;
    private UserNotificationUseCase userNotificationUseCase;
    private TransactionPinValidateUseCase  transactionPinValidateUseCase;

    public TransferUseCaseImpl(TransactionValidateUseCase transactionValidateUseCase,
                               FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase,
                               CreateTransactionUseCase createTransactionUseCase,
                               TransferGateway transferGateway,
                               UserNotificationUseCase userNotificationUseCase) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.transferGateway = transferGateway;
        this.userNotificationUseCase = userNotificationUseCase;
    }


    @Override
    public Boolean transfer(String toTaxNumber, String fromTaxNumber, BigDecimal value, String pin) {

        Wallet from = findWalletByTaxNumberUseCase.findWaletByTaxNumber(fromTaxNumber);
        Wallet to = findWalletByTaxNumberUseCase.findWaletByTaxNumber(toTaxNumber);

        from.transfer(value);
        to.reciveTransfer(value);

        var transaction = createTransactionUseCase.create(new Transaction(from, to, value));

        transactionValidateUseCase.validateTransaction(transaction);

        if(!transferGateway.transfer(transaction)) {
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(),  ErrorCodeEnum.TR0003.getCode());
        }

        if(!userNotificationUseCase.notificate(transaction, to.getUser().getEmail())){
            throw new NotificationException(ErrorCodeEnum.NO0001.getMessage(),  ErrorCodeEnum.NO0001.getCode());
        }

        return true;
    }
}
