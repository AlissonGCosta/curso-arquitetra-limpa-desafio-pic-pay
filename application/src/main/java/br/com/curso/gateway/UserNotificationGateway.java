package br.com.curso.gateway;

import br.com.curso.core.domain.Transaction;
import br.com.curso.core.domain.User;

public interface UserNotificationGateway {

    Boolean notificate(Transaction transaction, String email);
}
