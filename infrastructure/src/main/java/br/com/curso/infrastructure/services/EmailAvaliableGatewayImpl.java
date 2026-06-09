package br.com.curso.infrastructure.services;

import br.com.curso.gateway.EmailAvaliableGateway;
import br.com.curso.infrastructure.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.curso.infrastructure.Utils.Utilities.logger;

@Service
@RequiredArgsConstructor
public class EmailAvaliableGatewayImpl implements EmailAvaliableGateway {

    private final UserEntityRepository userEntityRepository;

    @Override
    public Boolean emailValiable(String email) {
        logger.info("Inicio da verificação se o Email esta disponivel");
        return !userEntityRepository.existsByEmail(email);
    }
}
