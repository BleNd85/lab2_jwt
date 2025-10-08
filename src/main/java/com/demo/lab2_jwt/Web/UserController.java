package com.demo.lab2_jwt.Web;

import com.demo.lab2_jwt.Dto.UserDto;
import com.demo.lab2_jwt.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserDto>> getHello() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/hello")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<String> getHelloUser() {
        UserDto user = userService.getUser();
        return ResponseEntity.ok("Hello " + user.getFullName() + "!!!");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        String deletedId = userService.deleteById(UUID.fromString(id));
        return ResponseEntity.ok(String.format("User with id %s was deleted", deletedId));
    }

}
