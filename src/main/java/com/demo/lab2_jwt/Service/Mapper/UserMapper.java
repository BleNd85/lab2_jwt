package com.demo.lab2_jwt.Service.Mapper;

import com.demo.lab2_jwt.Dto.UserDto;
import com.demo.lab2_jwt.Entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toUserEntity(UserDto userDto);

    List<UserEntity> toUserEntity(List<UserDto> userDto);

    UserDto toUserDto(UserEntity userEntity);

    List<UserDto> toUserDto(List<UserEntity> userEntity);
}
