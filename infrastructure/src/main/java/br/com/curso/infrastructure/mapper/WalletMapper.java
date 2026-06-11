package br.com.curso.infrastructure.mapper;

import br.com.curso.core.domain.Wallet;
import br.com.curso.infrastructure.entity.TransactionPinEntity;
import br.com.curso.infrastructure.entity.UserEntity;
import br.com.curso.infrastructure.entity.WalletsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WalletMapper {

    private final TransactionMapper transactionMapper;
    private final UserMapper userMapper;

    public WalletsEntity toWalletsEntity(Wallet wallet, UserEntity userEntity, TransactionPinEntity transactionPinEntity) {

        return new WalletsEntity(
               wallet.getBalance(),
                userEntity,
                transactionPinEntity,
                wallet.getCreatedAt(),
                wallet.getUpdatedAt()
        );
    }

    public Wallet toWallet(WalletsEntity walletsEntity) throws Exception {

        if(walletsEntity == null){
            return null;
        }
        return new Wallet(
                walletsEntity.getId(),
                transactionMapper.toTransactionPin(walletsEntity.getTransactionPinEntity()),
                walletsEntity.getBalance(),
                userMapper.toUser(walletsEntity.getUserEntity()),
                walletsEntity.getCreatedAt(),
                walletsEntity.getUpdateAt()

        );
    }
}
