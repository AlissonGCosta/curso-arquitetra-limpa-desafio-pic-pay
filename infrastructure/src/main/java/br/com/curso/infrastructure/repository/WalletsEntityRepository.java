package br.com.curso.infrastructure.entity.repository;

import br.com.curso.infrastructure.entity.WalletsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletsEntityRepository extends JpaRepository<WalletsEntity, Long> {
}
