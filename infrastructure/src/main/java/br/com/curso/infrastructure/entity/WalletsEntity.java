package br.com.curso.infrastructure.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "wallets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletsEntity {

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @OneToOne
    @JoinColumn(name = "UserId")
    private UserEntity userEntity;

    @OneToOne
    @JoinColumn(name = "TransactionPinId")
    private TransactionPinEntity TransactionPinEntity;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    public WalletsEntity(BigDecimal balance, UserEntity userEntity,
                         TransactionPinEntity transactionPinEntity,
                         LocalDateTime createdAt,
                         LocalDateTime updateAt) {
        this.balance = balance;
        this.userEntity = userEntity;
        TransactionPinEntity = transactionPinEntity;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
}
