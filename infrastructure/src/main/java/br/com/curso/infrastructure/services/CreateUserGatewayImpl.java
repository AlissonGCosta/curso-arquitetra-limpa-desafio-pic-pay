package br.com.curso.infrastructure.services;

import br.com.curso.core.domain.User;
import br.com.curso.core.domain.Wallet;
import br.com.curso.gateway.CreateUserGateway;
import br.com.curso.infrastructure.mapper.TransactionMapper;
import br.com.curso.infrastructure.mapper.UserMapper;
import br.com.curso.infrastructure.mapper.WalletMapper;
import br.com.curso.infrastructure.repository.TransactionPinEntityRepository;
import br.com.curso.infrastructure.repository.UserEntityRepository;
import br.com.curso.infrastructure.repository.WalletsEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.curso.infrastructure.Utils.Utilities.logger;

@Service
@RequiredArgsConstructor
public class CreateUserGatewayImpl implements CreateUserGateway {

    private final UserEntityRepository userEntityRepository;
    private final TransactionPinEntityRepository transactionPinEntityRepository;
    private final WalletsEntityRepository walletsEntityRepository;
    private final UserMapper userMapper;
    private final TransactionMapper transactionMapper;
    private final WalletMapper walletMapper;

    @Override
    @Transactional
    public Boolean create(User user, Wallet wallet) {
        try{
            logger.info("Iniciando processo de criaçãodo usuario::CreateUserGatewayImpl");
            var userSaved = userEntityRepository.save(userMapper.toUseEntity(user));
            var transactionPinSaved = transactionPinEntityRepository.save(transactionMapper.toTransactionPinEntity(wallet.getTransactionPin()));
            walletsEntityRepository.save(walletMapper.toWalletsEntity(wallet, userSaved, transactionPinSaved));
            logger.info("Processo finalizado com sucesso::CreateUserGatewayImpl");
            return true;
        }catch(Exception e){
            logger.error("Erro ao criar user::CreateUserGatewayImpl", e);
            return false;
        }

    }
}
