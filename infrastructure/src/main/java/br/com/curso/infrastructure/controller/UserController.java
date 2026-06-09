package br.com.curso.infrastructure.controller;

import br.com.curso.infrastructure.dto.response.BaseResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    public BaseResponse createUser(@RequestBody CreateUserRequest dto){

    }
}
