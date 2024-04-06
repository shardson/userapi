package com.java.aws.userapi.controller;

import com.java.aws.userapi.dto.UserDto;
import com.java.aws.userapi.model.UserDetailsRequestModel;
import com.java.aws.userapi.model.UserRest;
import com.java.aws.userapi.service.UserService;
import com.java.aws.userapi.service.UserServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(method = RequestMethod.GET, value = "/getusers/{id}")
    public UserRest getUser(@PathVariable String id){

        UserRest returnValue = new UserRest();

        UserDto userDto = userService.getUserByUserId(id);

        BeanUtils.copyProperties(userDto, returnValue);

        return returnValue;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/setuser")
    public UserRest setUser(@RequestBody UserDetailsRequestModel userDetails){
        //return "Set User" + " Nome = " + userDetails.getFirstName();
        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }

}
