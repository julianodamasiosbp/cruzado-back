package br.com.acme.cruzado.mapper;

import br.com.acme.cruzado.domain.dto.UserCreateDTO;
import br.com.acme.cruzado.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserCreateDTO userCreateDTO);

    UserCreateDTO toUserCreateDto(User user);
}
