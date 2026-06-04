package br.com.curso.gateway;

import br.com.curso.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceGateway {

    BigDecimal consult(Wallet wallet);
}
