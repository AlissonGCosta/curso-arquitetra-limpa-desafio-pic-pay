package br.com.curso.usecaseimpl;

import br.com.curso.core.domain.Wallet;
import br.com.curso.core.exception.NotFoundException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.gateway.FindWalletByTaxNumberGateway;
import br.com.curso.usecase.FindWalletByTaxNumberUseCase;

public class FindWalletByTaxNumberUseCaseImpl implements FindWalletByTaxNumberUseCase {

    private FindWalletByTaxNumberGateway findWalletByTaxNumberGateway;

    public FindWalletByTaxNumberUseCaseImpl(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        this.findWalletByTaxNumberGateway = findWalletByTaxNumberGateway;
    }


    @Override
    public Wallet findWaletByTaxNumber(String taxNumber) {


        var wallet = findWalletByTaxNumberGateway.findWalletByTaxNumber(taxNumber);

        if(wallet == null) {
            throw new NotFoundException(ErrorCodeEnum.WA0001.getMessage(), ErrorCodeEnum.WA0001.getCode());
        }


        return wallet;
    }
}
