package br.com.curso.gateway;

public interface UserAuthenticateGateway {

    Boolean authenticate(String username, String password);
}
