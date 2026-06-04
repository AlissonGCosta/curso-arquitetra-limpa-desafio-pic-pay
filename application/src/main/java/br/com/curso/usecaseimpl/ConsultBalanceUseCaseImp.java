package br.com.curso.usecaseimpl;

import br.com.curso.core.domain.Wallet;
import br.com.curso.gateway.ConsultBalanceGateway;
import br.com.curso.usecase.ConsultBalanceUseCase;

import java.math.BigDecimal;

public class ConsultBalanceUseCaseImp implements ConsultBalanceUseCase {

    private ConsultBalanceGateway consultBalanceGateway;

    public ConsultBalanceUseCaseImp(ConsultBalanceGateway consultBalanceGateway) {
        this.consultBalanceGateway = consultBalanceGateway;
    }

    @Override
    public BigDecimal consult(Wallet wallet) {

        return consultBalanceGateway.consult(wallet);
    }
}
