package com.demo.lab2_jwt.Dto.Auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "Username is required.")
    @Length(min = 2, max = 64, message = "Username must be 2 to 64 symbols long.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric.")
    private String username;

    @Length(min = 2, max = 64, message = "Full name must be 2 to 64 symbols long.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Full name must be alphanumeric.")
    @NotBlank(message = "Full name is required")
    private String fullName;

    @Length(min = 8, max = 128, message = "Password must be at least 8 symbols long.")
    @NotBlank(message = "Password is required.")
    private String password;

}
