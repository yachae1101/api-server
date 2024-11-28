package com.yachae1101.apiserver.controller;

import com.yachae1101.apiserver.dto.UserDTO;
import com.yachae1101.apiserver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    public final UserService userService;

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }
}
