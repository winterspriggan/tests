package com.example.libraryapp2.service.user;

import com.example.libraryapp2.domain.user.User;
import com.example.libraryapp2.domain.user.UserRepository;
import com.example.libraryapp2.dto.user.request.UserUpdateRequest;
import com.example.libraryapp2.dto.user.request.userCreateRequest;
import com.example.libraryapp2.dto.user.response.UserResponse;
import com.example.libraryapp2.repository.user.UserJdbcRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {

    private final UserRepository userRepository;
    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void saveUser(userCreateRequest request) {

      userRepository.save(new User(request.getName(), request.getAge()));

    }

    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }


    public void updateUser(UserUpdateRequest request) {
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);

        user.updateName(request.getName());
    }


    public void deleteUser(String name) {
        User user = userRepository.findByName(name)
                .orElseThrow(IllegalArgumentException::new);

        userRepository.delete(user);
    }


}
