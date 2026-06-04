package br.com.curso.gateway;

import br.com.curso.core.domain.Transaction;

public interface CreateTransactionGateway {

    Transaction create(Transaction transaction);
}
