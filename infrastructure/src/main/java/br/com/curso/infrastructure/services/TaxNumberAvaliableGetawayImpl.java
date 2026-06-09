package br.com.curso.infrastructure.services;

import br.com.curso.gateway.TaxNumberAvaliableGateway;
import br.com.curso.infrastructure.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TaxNumberAvaliableGetawayImpl implements TaxNumberAvaliableGateway {

    private final UserEntityRepository userEntityRepository;
    @Override
    public Boolean taxNumberAvailable(String taxNumber) {
        return null;
    }
}
