package com.desiertodigital.userinfo.controller;


import com.desiertodigital.userinfo.dto.UserDto;
import com.desiertodigital.userinfo.entity.User;
import com.desiertodigital.userinfo.mapper.UserMapper;
import com.desiertodigital.userinfo.repository.UserRepository;
import com.desiertodigital.userinfo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;

    private final UserRepository userRepository;

    @PostMapping("/addUser")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        UserDto saveUser = userService.addUser(userDto);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id){
        Optional<User> fetchedUser = userRepository.findById(id);

        if(fetchedUser.isPresent()){
            UserDto userDto = UserMapper.INSTANCE.mapUserToUserDto(fetchedUser.get());
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
