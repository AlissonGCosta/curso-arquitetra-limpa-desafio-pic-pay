package br.com.curso.usecaseimpl;

import br.com.curso.core.domain.TransactionPin;
import br.com.curso.core.domain.User;
import br.com.curso.core.domain.Wallet;
import br.com.curso.core.exception.EmailException;
import br.com.curso.core.exception.InternalServerErrorException;
import br.com.curso.core.exception.TaxNumberException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.gateway.CreateUserGateway;
import br.com.curso.usecase.*;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private CreateUserGateway createUserGateway;
    private TaxNumberAvaliableUseCase taxNumberAvaliableUseCase;
    private EmailAvailableUseCase emailAvailableUseCase;

    public CreateUserUseCaseImpl(TaxNumberAvaliableUseCase taxNumberAvaliableUseCase ,
                                 EmailAvailableUseCase emailAvailableUseCase,
                                 CreateUserGateway createUserGateway) {
        this.taxNumberAvaliableUseCase = taxNumberAvaliableUseCase;
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.createUserGateway = createUserGateway;

    }

    @Override
    public void create(User user, String pin) throws TaxNumberException, EmailException {

        if(!taxNumberAvaliableUseCase.taxNumberAvailable(user.getTaxNumber().getValue())){
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        if(!emailAvailableUseCase.emailAvailable(user.getEmail())){
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }

        if(!createUserGateway.create(user, new Wallet(BigDecimal.ZERO, user), new TransactionPin(user, pin))){
            throw new InternalServerErrorException(ErrorCodeEnum.ON0004.getMessage(), ErrorCodeEnum.ON0004.getCode());
        }


    }


}
