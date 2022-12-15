package br.com.acme.cruzado.controller;

import br.com.acme.cruzado.domain.dto.UserCreateDTO;
import br.com.acme.cruzado.mapper.UserMapper;
import br.com.acme.cruzado.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserCreateDTO> create(@RequestBody UserCreateDTO userCreateDTO) {

        UserCreateDTO SavedUserCreateDTO = UserMapper.INSTANCE.toUserCreateDto(userService.create(userCreateDTO));

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id").buildAndExpand(SavedUserCreateDTO.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

}
