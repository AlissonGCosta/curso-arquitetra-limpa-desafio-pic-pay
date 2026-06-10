package br.com.curso.infrastructure.config;

import br.com.curso.gateway.CreateUserGateway;
import br.com.curso.gateway.EmailAvaliableGateway;
import br.com.curso.gateway.TaxNumberAvaliableGateway;
import br.com.curso.usecase.CreateUserUseCase;
import br.com.curso.usecase.EmailAvailableUseCase;
import br.com.curso.usecase.TaxNumberAvaliableUseCase;
import br.com.curso.usecaseimpl.CreateUserUseCaseImpl;
import br.com.curso.usecaseimpl.EmailAvaliableUseCaseImpl;
import br.com.curso.usecaseimpl.TaxNumberAvaliableUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public EmailAvailableUseCase emailAvailableUseCase(EmailAvaliableGateway emailAvaliableGateway) {
        return  new EmailAvaliableUseCaseImpl(emailAvaliableGateway);
    }

    @Bean
    public TaxNumberAvaliableUseCase taxNumberAvaliableUseCase(TaxNumberAvaliableGateway taxNumberAvaliableGateway) {
        return new TaxNumberAvaliableUseCaseImpl(taxNumberAvaliableGateway);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(TaxNumberAvaliableUseCase taxNumberAvaliableUseCase ,
                                               EmailAvailableUseCase emailAvailableUseCase,
                                               CreateUserGateway createUserGateway) {
        return new CreateUserUseCaseImpl(taxNumberAvaliableUseCase,
                emailAvailableUseCase,
                createUserGateway);
    }
}
