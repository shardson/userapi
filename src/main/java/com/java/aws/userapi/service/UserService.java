package com.java.aws.userapi.service;

import com.java.aws.userapi.dto.UserDto;
import org.springframework.stereotype.Service;

public interface UserService {

    UserDto createUser(UserDto userDto);

}