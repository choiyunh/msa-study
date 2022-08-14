package com.uno.userservice.service;

import com.uno.userservice.dto.UserDto;
import com.uno.userservice.model.User;

public interface UserService {
    void createUser(UserDto userDto);
    UserDto getUserByUuid(String uuid);
    Iterable<User> getUserByAll();
}
