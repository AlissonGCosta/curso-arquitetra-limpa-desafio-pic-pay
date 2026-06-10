package br.com.curso.infrastructure.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TransactionsPin")
public class TransactionPinEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pin", nullable = false)
    private String pin;

    @Column(name = "attempt", nullable = false)
    private Integer attempt;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

    @Column(name = "blocked", nullable = false )
    private Boolean blocked;

    public TransactionPinEntity(String pin, Integer attempt, LocalDateTime createdAt, LocalDateTime updateAt, Boolean blocked) {
        this.pin = pin;
        this.attempt = attempt;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.blocked = blocked;
    }

}
