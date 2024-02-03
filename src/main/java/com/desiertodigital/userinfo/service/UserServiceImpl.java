package com.desiertodigital.userinfo.service;

import com.desiertodigital.userinfo.dto.UserDto;
import com.desiertodigital.userinfo.entity.User;
import com.desiertodigital.userinfo.mapper.UserMapper;
import com.desiertodigital.userinfo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserDto addUser(UserDto userDto) {
        User user  = userRepository.save(UserMapper.INSTANCE.mapUserDtoToUser(userDto));
        return UserMapper.INSTANCE.mapUserToUserDto(user);
    }

    @Override
    public UserDto getUserById(Long id) {
        User queriedUser = userRepository.findById(id).get();
        return null;
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> allUsers = userRepository.findAll();

        return allUsers.stream()
                .map(user -> UserMapper.INSTANCE.mapUserToUserDto(user))
                .collect(Collectors.toList());
    }
}
