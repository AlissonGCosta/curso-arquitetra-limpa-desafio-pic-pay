package br.com.curso.core.domain;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class User {

    private UUID id;
    private String email;
    private String password;
    private TaxNumber taxNumber;
    private String fullname;
    private UserTypeEnum type;
    private TransactionPin transactionPin;
    private LocalDate cratedAt;
    private LocalDate updatedAt;

    public User(LocalDate cratedAt, LocalDate updatedAt, UserTypeEnum type, TransactionPin transactionPin, TaxNumber taxNumber, String password, UUID id, String fullname, String email) {
        this.cratedAt = cratedAt;
        this.updatedAt = updatedAt;
        this.type = type;
        this.transactionPin = transactionPin;
        this.taxNumber = taxNumber;
        this.password = password;
        this.id = id;
        this.fullname = fullname;
        this.email = email;
    }

    public User(String email, String password, TaxNumber taxNumber, String fullname, UserTypeEnum type, TransactionPin transactionPin) {
        this.email = email;
        this.password = password;
        this.taxNumber = taxNumber;
        this.fullname = fullname;
        this.type = type;
        this.transactionPin = transactionPin;
    }

    public User() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public TaxNumber getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(TaxNumber taxNumber) {
        this.taxNumber = taxNumber;
    }

    public UserTypeEnum getType() {
        return type;
    }

    public void setType(UserTypeEnum type) {
        this.type = type;
    }

    public TransactionPin getTransactionPin() {
        return transactionPin;
    }

    public void setTransactionPin(TransactionPin transactionPin) {
        this.transactionPin = transactionPin;
    }

    public LocalDate getCratedAt() {
        return cratedAt;
    }



    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof User user)) return false;

        return getId().equals(user.getId()) && getEmail().equals(user.getEmail()) && getPassword().equals(user.getPassword()) && getTaxNumber().equals(user.getTaxNumber()) && getFullname().equals(user.getFullname()) && getType() == user.getType() && getTransactionPin().equals(user.getTransactionPin()) && getCratedAt().equals(user.getCratedAt()) && Objects.equals(getUpdatedAt(), user.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getTaxNumber().hashCode();
        result = 31 * result + getFullname().hashCode();
        result = 31 * result + getType().hashCode();
        result = 31 * result + getTransactionPin().hashCode();
        result = 31 * result + getCratedAt().hashCode();
        result = 31 * result + Objects.hashCode(getUpdatedAt());
        return result;
    }
}
