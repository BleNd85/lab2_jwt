package com.demo.lab2_jwt.Dto.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    @Length(min = 2, max = 64, message = "Username must be 2 to 64 symbols long.")
    private String username;
    @Length(min = 2, max = 128, message = "Password can be 128 symbols long.")
    private String password;
}
