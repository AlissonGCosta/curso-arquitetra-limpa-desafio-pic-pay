package br.com.curso.gateway;

import br.com.curso.core.domain.Wallet;

public interface FindWalletByTaxNumberGateway {

    Wallet findWalletByTaxNumber(String taxNumber) throws Exception;
}
