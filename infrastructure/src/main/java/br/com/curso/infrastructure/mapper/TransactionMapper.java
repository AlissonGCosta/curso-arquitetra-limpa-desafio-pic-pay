package br.com.curso.infrastructure.mapper;

import br.com.curso.core.domain.TransactionPin;
import br.com.curso.infrastructure.entity.TransactionEntity;
import br.com.curso.infrastructure.entity.TransactionPinEntity;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public TransactionPinEntity toTransactionPinEntity(TransactionPin transaction){

        return new TransactionPinEntity(
                transaction.getPin(),
                transaction.getAttempt(),
                transaction.getCreatedAt(),
                transaction.getUpdatedAt(),
                transaction.getBlocked()
        );

    }

    public TransactionPin toTransactionPin(TransactionPinEntity transactionPinEntity) {

        return new TransactionPin(
                transactionPinEntity.getUpdateAt(),
                transactionPinEntity.getPin(),
                transactionPinEntity.getId(),
                transactionPinEntity.getCreatedAt(),
                transactionPinEntity.getBlocked(),
                transactionPinEntity.getAttempt()



        );
    }
}
