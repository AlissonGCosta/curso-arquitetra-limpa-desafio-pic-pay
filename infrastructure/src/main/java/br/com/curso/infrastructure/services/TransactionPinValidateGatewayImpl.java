package br.com.curso.infrastructure.services;

import br.com.curso.core.domain.TransactionPin;
import br.com.curso.gateway.TransactionPinValidateGateway;
import br.com.curso.infrastructure.repository.TransactionPinEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionPinValidateGatewayImpl implements TransactionPinValidateGateway {

    private final TransactionPinEntityRepository transactionPinEntityRepository;

    @Override
    public boolean validatePin(TransactionPin transactionPin) {
        var transactionPinSaved = transactionPinEntityRepository.findById(transactionPin.getId());
        if (transactionPinSaved.isEmpty()) {
            return false;
        }

        if(!transactionPinSaved.get().getPin().equals(transactionPin.getPin())) {
            return false;
        }

        return true;
    }
}
