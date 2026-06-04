package br.com.curso.core.domain;

import br.com.curso.core.exception.TrasnferException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Wallet {

    private Long id;
    private BigDecimal balance;
    private User user;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Wallet(BigDecimal balance, Long id, LocalDate createdAt, LocalDate updatedAt, User user) {
        this.balance = balance;
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
    }

    public Wallet(BigDecimal balance, User user) {
        this.balance = balance;
        this.user = user;
        this.createdAt = LocalDate.now();
    }

    public Wallet() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDate getCreatedAt() {
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
}
