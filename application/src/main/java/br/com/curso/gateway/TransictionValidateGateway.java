package br.com.curso.gateway;

import br.com.curso.core.domain.Transaction;

public interface TransictionValidateGateway {

    Boolean validate(Transaction transaction);
}
