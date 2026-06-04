package br.com.curso.gateway;

import br.com.curso.core.domain.User;
import br.com.curso.core.exception.EmailException;
import br.com.curso.core.exception.TaxNumberException;

public interface CreateUserGateway {
    User create(User user);
}
