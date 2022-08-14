package com.uno.userservice.controller;

import com.uno.userservice.dto.UserDto;
import com.uno.userservice.model.User;
import com.uno.userservice.vo.ResponseUser;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.uno.userservice.service.UserService;
import com.uno.userservice.vo.RequestUser;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user-service")
public class UserController {
    Environment env;
    UserService userService;

    @Autowired
    public UserController(Environment env, UserService userService) {
        this.env = env;
        this.userService = userService;
    }

    @GetMapping("/health_check")
    public String status() {
        return String.format("It's working in user service on PORT %s",
                env.getProperty("local.server.port"));
    }

    @PostMapping("/user")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser user) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = modelMapper.map(user, UserDto.class);
        userService.createUser(userDto);

        ResponseUser responseUser = modelMapper.map(userDto, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }

    @GetMapping("/user")
    public ResponseEntity<List<ResponseUser>> getUsers() {
        Iterable<User> users = userService.getUserByAll();

        List<ResponseUser> result = new ArrayList<>();
        users.forEach(v ->
            result.add(new ModelMapper().map(v, ResponseUser.class)));


        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/user/{uuid}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable("uuid") String uuid) {
        UserDto userDto = userService.getUserByUuid(uuid);

        ResponseUser result = new ModelMapper().map(userDto, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
