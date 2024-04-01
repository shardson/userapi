package com.java.aws.userapi.service;

import com.java.aws.userapi.dto.UserDto;
import com.java.aws.userapi.entity.UserEntity;
import com.java.aws.userapi.repository.UserRepository;
import com.java.aws.userapi.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Override
    public UserDto createUser(UserDto user) {

        if(userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Registro já existe para esse email");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        userEntity.setEncryptedPassword("test");

        String PublicUserId = utils.generateUserId(10);
        userEntity.setUserId(PublicUserId);


        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();

        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }
}
