package br.com.curso.gateway;

import br.com.curso.core.domain.Wallet;

public interface CreateWalletGateway {

    void create(Wallet wallet);
}
