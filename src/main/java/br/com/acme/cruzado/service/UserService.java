package br.com.acme.cruzado.service;

import br.com.acme.cruzado.domain.dto.UserCreateDTO;
import br.com.acme.cruzado.domain.model.User;
import br.com.acme.cruzado.mapper.UserMapper;
import br.com.acme.cruzado.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(UserCreateDTO userCreateDTO) {
        findByEmail(userCreateDTO);

        return userRepository.save(UserMapper.INSTANCE.toUser(userCreateDTO));
    }

    private void findByEmail(UserCreateDTO userCreateDTO) {
        userRepository.findByEmail(userCreateDTO.getEmail()).ifPresent(
                (userFound) -> {
                    if(userFound.getId().equals(userCreateDTO.getId())) {
                        throw new DataIntegrityViolationException("Email already exists!");
                    }
                }
        );
    }

}
