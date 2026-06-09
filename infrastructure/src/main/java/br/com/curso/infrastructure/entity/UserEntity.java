package br.com.curso.infrastructure.entity;

import br.com.curso.core.domain.UserTypeEnum;
import jakarta.persistence.*;
import lombok.*;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
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

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserTypeEnum type;

    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updateAt", nullable = false)
    private LocalDateTime updateAt;


}
