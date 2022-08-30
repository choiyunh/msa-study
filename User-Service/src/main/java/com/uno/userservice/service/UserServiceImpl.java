package com.uno.userservice.service;

import com.uno.userservice.dto.UserDto;
import com.uno.userservice.mapper.UserMapper;
import com.uno.userservice.model.User;
import com.uno.userservice.repository.UserRepository;
import com.uno.userservice.vo.ResponseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUser(UserDto userDto) {
        userDto.setUuid(UUID.randomUUID().toString());

        User user = UserMapper.INSTANCE.dtoToEntity(userDto);
        user.setEncryptedPwd(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles("ROLE_USER");

        userRepository.save(user);
    }

    @Override
    public UserDto getUserByUuid(String uuid) {
        User user = userRepository.findByUuid(uuid);

        if (user == null)
            throw new UsernameNotFoundException("User not found");

        UserDto userDto = UserMapper.INSTANCE.entityToDto(user);

        List<ResponseOrder> orders = new ArrayList<>();
        userDto.setOrders(orders);

        return userDto;
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
