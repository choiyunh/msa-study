package com.uno.userservice.mapper;

import com.uno.userservice.dto.UserDto;
import com.uno.userservice.model.User;
import com.uno.userservice.vo.RequestUser;
import com.uno.userservice.vo.ResponseUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto requestToDto(RequestUser requestUser);

    User dtoToEntity(UserDto userDto);

    UserDto entityToDto(User user);

    ResponseUser dtoToResponse(UserDto userDto);

    ResponseUser entityToResponse(User user);




}
