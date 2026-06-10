package br.com.curso.infrastructure.entity;

import br.com.curso.core.domain.UserTypeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserEntity {

    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "tax_number", nullable = false )
    private String taxNumber;

    @Column(name = "password", nullable = false )
    private String password;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserTypeEnum type;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;



}
