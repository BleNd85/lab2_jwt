package com.demo.lab2_jwt.Dto;

import com.demo.lab2_jwt.Common.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserDto {

    private UUID id;

    private String username;

    private String fullName;

    private Role role;

}
