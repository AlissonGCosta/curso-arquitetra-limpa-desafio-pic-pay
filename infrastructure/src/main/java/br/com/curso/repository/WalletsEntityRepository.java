package br.com.curso.repository;

import br.com.curso.entity.WalletsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletsEntityRepository extends JpaRepository<WalletsEntity, Long> {
}
