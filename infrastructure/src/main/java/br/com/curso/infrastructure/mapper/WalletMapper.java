package br.com.curso.infrastructure.mapper;

import br.com.curso.core.domain.Wallet;
import br.com.curso.infrastructure.entity.TransactionPinEntity;
import br.com.curso.infrastructure.entity.UserEntity;
import br.com.curso.infrastructure.entity.WalletsEntity;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {

    public WalletsEntity toWalletsEntity(Wallet wallet, UserEntity userEntity, TransactionPinEntity transactionPinEntity) {

        return new WalletsEntity(
               wallet.getBalance(),
                userEntity,
                transactionPinEntity,
                wallet.getCreatedAt(),
                wallet.getUpdatedAt()
        );
    }
}
