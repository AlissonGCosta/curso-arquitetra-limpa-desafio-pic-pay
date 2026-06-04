package br.com.curso.core.domain;

import br.com.curso.core.exception.TransactionPinExcption;
import br.com.curso.core.exception.enums.ErrorCodeEnum;

import java.time.LocalDate;

public class TransactionPin {

    private Long id;

    private User user;

    private String pin;

    private Integer attempt;

    private boolean blocked;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    public TransactionPin(User user, LocalDate updatedAt, String pin, Long id, LocalDate createdAt, boolean blocked, Integer attempt) {
        this.user = user;
        this.updatedAt = updatedAt;
        this.pin = pin;
        this.id = id;
        this.createdAt = createdAt;
        this.blocked = blocked;
        this.attempt = attempt;
    }

    public TransactionPin(User user, String pin) {
        this.user = user;
        setPin(pin);
        this.attempt = 3;
        this.blocked = false;
        this.createdAt = LocalDate.now();
    }

    public TransactionPin() {}

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


    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt(Integer attempt) {
        this.attempt = attempt;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) throws TransactionPinExcption {
        pinIsValid(pin);
        this.pin = pin;
    }

    private void pinIsValid(String pin) throws  TransactionPinExcption {
        if (pin.length() != 8) {
            throw new TransactionPinExcption(ErrorCodeEnum.TRP0001.getMessage(), ErrorCodeEnum.TRP0001.getCode());
        }

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
