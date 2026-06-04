package br.com.curso.gateway;

import br.com.curso.core.domain.Transaction;

public interface TransferGateway {
    Boolean transfer(Transaction transaction);
}
