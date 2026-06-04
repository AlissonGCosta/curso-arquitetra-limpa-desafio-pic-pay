package br.com.curso.usecaseimpl;

import br.com.curso.gateway.EmailAvaliableGateway;
import br.com.curso.usecase.EmailAvailableUseCase;

public class EmailAvaliableUseCaseImpl  implements EmailAvailableUseCase {

    private EmailAvaliableGateway emailAvaliableGateway;

    public EmailAvaliableUseCaseImpl(EmailAvaliableGateway emailAvaliableGateway) {
        this.emailAvaliableGateway = emailAvaliableGateway;
    }

    @Override
    public Boolean emailAvailable(String email) {
        return emailAvaliableGateway.emailValiable(email);
    }
}
