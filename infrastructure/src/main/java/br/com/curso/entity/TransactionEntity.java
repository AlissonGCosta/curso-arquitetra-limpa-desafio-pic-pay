package br.com.curso.entity;

import br.com.curso.core.domain.TransactionStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FromWallet")
    private WalletsEntity fromWallet;

    @ManyToOne
    @JoinColumn(name = "ToWallet")
    private WalletsEntity toWallet;

    @Column(name = "transaction_value", nullable = false)
    private BigDecimal value;

    @Column(name = "status", nullable = false)
    private TransactionStatusEnum status;

    @Column(name = "createdAt", nullable = false)
    @Enumerated(EnumType.STRING)
    private LocalDateTime createdAt;

    @Column(name = "updateAt", nullable = false)
    private LocalDateTime updateAt;


}
