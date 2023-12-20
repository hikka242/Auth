package com.example.authtry3.service;


import com.example.authtry3.dto.User;
import com.example.authtry3.dto.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();
}
