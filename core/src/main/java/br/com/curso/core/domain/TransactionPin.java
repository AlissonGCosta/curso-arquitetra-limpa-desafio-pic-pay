package br.com.curso.core.domain;

import br.com.curso.core.exception.TransactionPinExcption;
import br.com.curso.core.exception.enums.ErrorCodeEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class TransactionPin {

    private Long id;


    private String pin;

    private Integer attempt;

    private Boolean blocked;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public TransactionPin( LocalDateTime updatedAt,
                           String pin, Long id,
                           LocalDateTime createdAt,
                           Boolean blocked,
                           Integer attempt) {
        this.updatedAt = updatedAt;
        this.pin = pin;
        this.id = id;
        this.createdAt = createdAt;
        this.blocked = blocked;
        this.attempt = attempt;
    }

    public TransactionPin(String pin) {
        setPin(pin);
        this.attempt = 3;
        this.blocked = false;
        this.createdAt = LocalDateTime.now();
    }

    public TransactionPin() {}

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


    public boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt() {
        if(this.attempt == 1) {
            this.blocked = true;
            this.attempt = 0;
        } else {
            this.attempt = this.attempt - 1;
        }
    }

    public void restaureAttempt() {
        this.attempt = 3;
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

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof TransactionPin that)) return false;

        return getBlocked() == that.getBlocked() && getId().equals(that.getId()) && Objects.equals(getPin(), that.getPin()) && Objects.equals(getAttempt(), that.getAttempt()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) && getUpdatedAt().equals(that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + Objects.hashCode(getPin());
        result = 31 * result + Objects.hashCode(getAttempt());
        result = 31 * result + Boolean.hashCode(getBlocked());
        result = 31 * result + Objects.hashCode(getCreatedAt());
        result = 31 * result + getUpdatedAt().hashCode();
        return result;
    }
}
