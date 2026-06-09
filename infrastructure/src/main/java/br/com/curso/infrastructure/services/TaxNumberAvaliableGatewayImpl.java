package br.com.curso.infrastructure.services;

import br.com.curso.gateway.TaxNumberAvaliableGateway;
import br.com.curso.infrastructure.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.curso.infrastructure.Utils.Utilities.logger;

@Service
@RequiredArgsConstructor
public class TaxNumberAvaliableGatewayImpl implements TaxNumberAvaliableGateway {

    private final UserEntityRepository userEntityRepository;
    @Override
    public Boolean taxNumberAvailable(String taxNumber) {
        logger.info("Inicio da verificação se o TaxNumber esta disponivel");
        return !userEntityRepository.existsByTaxNumber(taxNumber);
    }
}
