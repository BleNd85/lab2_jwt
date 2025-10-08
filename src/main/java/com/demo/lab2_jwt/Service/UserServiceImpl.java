package com.demo.lab2_jwt.Service;

import com.demo.lab2_jwt.Dto.UserDto;
import com.demo.lab2_jwt.Entity.UserEntity;
import com.demo.lab2_jwt.Repository.UserRepository;
import com.demo.lab2_jwt.Service.Mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDto> getAll() {
        return userMapper.toUserDto(userRepository.findAll());
    }

    @Override
    public UserDto getUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepository.findByUsername(username).orElseThrow();
        return userMapper.toUserDto(user);
    }

    @Override
    public String deleteById(UUID id) {
        userRepository.deleteById(id);
        return id.toString();
    }
}
