package br.com.curso.core.domain;

import br.com.curso.core.exception.TrasnferException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Wallet {

    private Long id;

    private TransactionPin transactionPin;

    private BigDecimal balance;
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Wallet(TransactionPin  transactionPin,
                  BigDecimal balance,
                  Long id,
                  LocalDateTime createdAt,
                  LocalDateTime updatedAt,
                  User user) {
        this.balance = balance;
        this.id = id;
        this.transactionPin = transactionPin;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
    }

    public Wallet(BigDecimal balance,
                  User user,
                  TransactionPin transactionPin) {
        this.transactionPin = transactionPin;
        this.balance = balance;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }

    public Wallet() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void receivValue(BigDecimal value) {
        this.balance.add(value);
   }

    public TransactionPin getTransactionPin() {return transactionPin;}

    public void setTransactionPin(TransactionPin transactionPin) {
        this.transactionPin = transactionPin;
    }

    public void transfer(BigDecimal value) throws TrasnferException {
        if(this.user.getType() == UserTypeEnum.SHOPKEEPER){
            throw new TrasnferException(ErrorCodeEnum.TR0001.getMessage(), ErrorCodeEnum.TR0001.getCode());
        }

        if(this.balance.compareTo(value) < 0){
            throw new TrasnferException(ErrorCodeEnum.TR0002.getMessage(), ErrorCodeEnum.TR0002.getCode());
        }

        this.balance.subtract(value);
    }

    public void reciveTransfer(BigDecimal value) throws TrasnferException {

        this.balance.add(value);
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Wallet wallet)) return false;

        return Objects.equals(getId(), wallet.getId()) && getTransactionPin().equals(wallet.getTransactionPin()) && getBalance().equals(wallet.getBalance()) && getUser().equals(wallet.getUser()) && getCreatedAt().equals(wallet.getCreatedAt()) && Objects.equals(getUpdatedAt(), wallet.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getId());
        result = 31 * result + getTransactionPin().hashCode();
        result = 31 * result + getBalance().hashCode();
        result = 31 * result + getUser().hashCode();
        result = 31 * result + getCreatedAt().hashCode();
        result = 31 * result + Objects.hashCode(getUpdatedAt());
        return result;
    }
}
