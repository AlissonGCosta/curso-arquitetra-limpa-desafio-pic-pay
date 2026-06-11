package br.com.curso.infrastructure.mapper;

import br.com.curso.core.domain.TaxNumber;
import br.com.curso.core.domain.User;
import br.com.curso.infrastructure.dto.request.CreateUserRequest;
import br.com.curso.infrastructure.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toUseEntity(User user){

        return new UserEntity(
                user.getId(),
                user.getEmail(),
                user.getTaxNumber().getValue(),
                user.getPassword(),
                user.getFullName(),
                user.getType(),
                user.getCratedAt(),
                user.getUpdatedAt()
        );
    }

    public User toUser(CreateUserRequest dto) throws Exception {
        return new User(
                dto.email(),
                dto.password(),
                new TaxNumber(dto.taxNumber()),
                dto.fullName(),
                dto.type()
        );
    }

    public User toUser(UserEntity dto) throws Exception {
        return new User(
                dto.getId(),
                dto.getEmail(),
                dto.getPassword(),
                dto.getFullName(),
                new TaxNumber(dto.getTaxNumber()),
                dto.getType(),
                dto.getCreatedAt(),
                dto.getUpdateAt()

        );
    }
}
