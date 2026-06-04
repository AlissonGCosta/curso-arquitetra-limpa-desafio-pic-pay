package br.com.curso.usecaseimpl;

import br.com.curso.core.exception.AuthenticateException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.gateway.UserAuthenticateGateway;
import br.com.curso.usecase.UserAuthenticateUseCase;

public class UserAuthenticateUseCaseImpl implements UserAuthenticateUseCase {

    private UserAuthenticateGateway userAuthenticateGateway;

    public void setUserAuthenticateGateway(UserAuthenticateGateway userAuthenticateGateway) {
        this.userAuthenticateGateway = userAuthenticateGateway;
    }

    @Override
    public Boolean authenticate(String username, String password) {

        if(!userAuthenticateGateway.authenticate(username, password)) {
            throw new AuthenticateException(ErrorCodeEnum.AUT0001.getMessage(), ErrorCodeEnum.AUT0001.getCode());
        }

        return true;
    }
}
