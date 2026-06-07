package br.com.curso.usecaseimpl;

import br.com.curso.core.domain.Transaction;
import br.com.curso.core.domain.Wallet;

import br.com.curso.core.exception.*;
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
                               UserNotificationUseCase userNotificationUseCase,
                               TransactionPinValidateUseCase transactionPinValidateUseCase) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.transferGateway = transferGateway;
        this.userNotificationUseCase = userNotificationUseCase;
        this.transactionPinValidateUseCase = transactionPinValidateUseCase;
    }


    @Override
    public Boolean transfer(String toTaxNumber, String fromTaxNumber, BigDecimal value, String pin) {

        Wallet from = findWalletByTaxNumberUseCase.findWaletByTaxNumber(fromTaxNumber);
        Wallet to = findWalletByTaxNumberUseCase.findWaletByTaxNumber(toTaxNumber);

        if(from.getTransactionPin().isBlocked()){
            throw new PinException(ErrorCodeEnum.PIN0001.getMessage(), ErrorCodeEnum.PIN0001.getCode());
        }

        transactionPinValidateUseCase.validate(from.getTransactionPin());

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
