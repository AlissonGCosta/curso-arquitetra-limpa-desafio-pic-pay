package br.com.curso.infrastructure.services;

import br.com.curso.core.domain.Wallet;
import br.com.curso.gateway.FindWalletByTaxNumberGateway;
import br.com.curso.infrastructure.mapper.WalletMapper;
import br.com.curso.infrastructure.repository.WalletsEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindWalletByTaxNumberGatewayImpl implements FindWalletByTaxNumberGateway {

    private final WalletsEntityRepository walletEntityRepository;
    private final WalletMapper walletMapper;

    @Override
    public Wallet findWalletByTaxNumber(String taxNumber) throws Exception {
        return walletMapper.toWallet(walletEntityRepository.findByUserEntityTaxNumber(taxNumber)) ;

    }
}
