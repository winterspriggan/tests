package com.example.libraryapp2.controller.user;

import com.example.libraryapp2.domain.user.Fruit;
import com.example.libraryapp2.dto.user.request.UserUpdateRequest;
import com.example.libraryapp2.dto.user.request.userCreateRequest;
import com.example.libraryapp2.dto.user.response.UserResponse;
import com.example.libraryapp2.service.user.UserServiceV1;
import com.example.libraryapp2.service.user.UserServiceV2;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class userController {

    private final UserServiceV2 userService;

    public userController(UserServiceV2 userService) {
        this.userService = userService;
    }

    @PostMapping("/user") // POST /user
    public void saveUser(@RequestBody userCreateRequest request) {
        userService.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        userService.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        userService.deleteUser(name);
    }

}

