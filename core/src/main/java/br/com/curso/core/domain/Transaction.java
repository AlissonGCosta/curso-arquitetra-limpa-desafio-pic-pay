package br.com.curso.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Transaction {

    private Long id;
    private Wallet fromWallet;
    private Wallet toWallet;
    private BigDecimal value;
    private TransactionStatusEnum status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Transaction(LocalDateTime createdAt, Wallet fromWallet, Long id, TransactionStatusEnum status, Wallet toWallet, BigDecimal value, LocalDateTime updatedAt) {
        this.createdAt = createdAt;
        this.fromWallet = fromWallet;
        this.id = id;
        this.status = status;
        this.toWallet = toWallet;
        this.value = value;
        this.updatedAt = updatedAt;
    }

    public Transaction(Wallet fromWallet, Wallet toWallet, BigDecimal value) {
        this.fromWallet = fromWallet;
        this.toWallet = toWallet;
        this.value = value;
        this.status = TransactionStatusEnum.CREATED;
        this.createdAt = LocalDateTime.now();
    }

    public Transaction() {
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public BigDecimal getValue() {
        return value;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Wallet getToWallet() {
        return toWallet;
    }

    public TransactionStatusEnum getStatus() {
        return status;
    }

    public Long getId() {
        return id;
    }

    public Wallet getFromWallet() {
        return fromWallet;
    }


    public void setFromWallet(Wallet fromWallet) {
        this.fromWallet = fromWallet;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(TransactionStatusEnum status) {
        this.status = status;
    }

    public void setToWallet(Wallet toWallet) {
        this.toWallet = toWallet;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Transaction that)) return false;

        return Objects.equals(getId(), that.getId()) && getFromWallet().equals(that.getFromWallet()) && getToWallet().equals(that.getToWallet()) && getValue().equals(that.getValue()) && getStatus() == that.getStatus() && getCreatedAt().equals(that.getCreatedAt()) && Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getId());
        result = 31 * result + getFromWallet().hashCode();
        result = 31 * result + getToWallet().hashCode();
        result = 31 * result + getValue().hashCode();
        result = 31 * result + getStatus().hashCode();
        result = 31 * result + getCreatedAt().hashCode();
        result = 31 * result + Objects.hashCode(getUpdatedAt());
        return result;
    }
}
