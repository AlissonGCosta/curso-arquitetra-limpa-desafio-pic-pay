package br.com.curso.usecaseimpl;

import br.com.curso.gateway.EmailAvaliableGateway;
import br.com.curso.gateway.TaxNumberAvaliableGateway;
import br.com.curso.usecase.TaxNumberAvaliableUseCase;

public class TaxNumberAvaliableUseCaseImpl implements TaxNumberAvaliableUseCase {

    private TaxNumberAvaliableGateway taxNumberAvaliableGateway;

    public TaxNumberAvaliableUseCaseImpl(TaxNumberAvaliableGateway taxNumberAvaliableGateway) {
        this.taxNumberAvaliableGateway = taxNumberAvaliableGateway;
    }

    @Override
    public Boolean taxNumberAvailable(String taxNumber) {
        return taxNumberAvaliableGateway.taxNumberAvailable(taxNumber);
    }
}
