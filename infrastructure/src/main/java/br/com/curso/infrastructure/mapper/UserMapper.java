package br.com.curso.infrastructure.mapper;

import br.com.curso.core.domain.User;
import br.com.curso.infrastructure.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toUseEntity(User user){

        return new UserEntity(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getTaxNumber().getValue(),
                user.getFullname(),
                user.getType(),
                user.getCratedAt(),
                user.getUpdatedAt()
        );
    }
}
