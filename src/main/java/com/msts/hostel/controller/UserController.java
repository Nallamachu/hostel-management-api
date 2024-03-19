package com.msts.hostel.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msts.hostel.document.User;
import com.msts.hostel.model.LoginDto;
import com.msts.hostel.model.UserDto;
import com.msts.hostel.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/hostel/v1/api")
@SecurityRequirement(name = "HostelOpenAPI")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping(path = "/")
    public String getMessage() {
        return "Welcome to Hostel world";
    }

    @PostMapping(path = "/login",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto login(@RequestBody LoginDto loginDto) {
        if(loginDto == null)
            return null;

        User user = userService.authenticateUser(loginDto);
        return objectMapper.convertValue(user, UserDto.class);
    }

    @PostMapping(path = "/register-user",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto registerUser(@RequestBody UserDto userDto) {
        if(userDto == null)
            return null;
        User user = objectMapper.convertValue(userDto, User.class);
        user = userService.registerUser(user);
        return objectMapper.convertValue(user, UserDto.class);
    }
}
