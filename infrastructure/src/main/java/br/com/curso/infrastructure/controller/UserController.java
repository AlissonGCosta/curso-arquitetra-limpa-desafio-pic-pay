package br.com.curso.infrastructure.controller;

import br.com.curso.infrastructure.dto.request.CreateUserRequest;
import br.com.curso.infrastructure.dto.response.BaseResponse;
import br.com.curso.infrastructure.mapper.UserMapper;
import br.com.curso.usecase.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static br.com.curso.infrastructure.Utils.Utilities.logger;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final UserMapper userMapper;

    @PostMapping
    public BaseResponse<String> createUser(@RequestBody CreateUserRequest dto) throws Exception {
        logger.info("Inicioda criação do usuario::UserController ");
        createUserUseCase.create(userMapper.toUser(dto), dto.pin());
        logger.info("Usuario criado com sucesso::UserController ");
        return BaseResponse.<String>builder().success(true).message("Usuario criado com sucesso!").build();
    }
}
