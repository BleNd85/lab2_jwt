package com.demo.lab2_jwt.Service;


import com.demo.lab2_jwt.Dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserDto> getAll();

    UserDto getUser();

    String deleteById(UUID id);

}
