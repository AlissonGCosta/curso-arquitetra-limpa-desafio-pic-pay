package br.com.curso.core.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class User {

    private UUID id;
    private String email;
    private String password;
    private TaxNumber taxNumber;
    private String fullName;
    private UserTypeEnum type;
    private LocalDateTime cratedAt;
    private LocalDateTime updatedAt;

    public User(LocalDateTime cratedAt,
                LocalDateTime updatedAt,
                UserTypeEnum type,
                TaxNumber taxNumber,
                String password,
                UUID id,
                String fullName,
                String email) {
        this.cratedAt = cratedAt;
        this.updatedAt = updatedAt;
        this.type = type;

        this.taxNumber = taxNumber;
        this.password = password;
        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }

    public User(String email,
                String password,
                TaxNumber taxNumber,
                String fullName,
                UserTypeEnum type) {
        this.email = email;
        this.password = password;
        this.taxNumber = taxNumber;
        this.fullName = fullName;
        this.type = type;
        this.cratedAt = LocalDateTime.now();

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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



    public LocalDateTime getCratedAt() {
        return cratedAt;
    }



    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof User user)) return false;

        return getId().equals(user.getId()) && getEmail().equals(user.getEmail()) && getPassword().equals(user.getPassword()) && getTaxNumber().equals(user.getTaxNumber()) && getCratedAt().equals(user.getCratedAt()) && Objects.equals(getUpdatedAt(), user.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getTaxNumber().hashCode();
        result = 31 * result + getFullName().hashCode();
        result = 31 * result + getType().hashCode();
        result = 31 * result + getCratedAt().hashCode();
        result = 31 * result + Objects.hashCode(getUpdatedAt());
        return result;
    }
}
