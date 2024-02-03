package com.desiertodigital.userinfo.service;

import com.desiertodigital.userinfo.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto addUser(UserDto userDto);

    UserDto getUserById(Long id);
    List<UserDto> getAllUser();
}
