package com.java.aws.userapi.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class Utils {

    private final Random RANDOM = new SecureRandom();
    private final String Alfabeto = "0123456789ABCDEFGHIJKLMNOPQRSTUVXZabcdefghijklmnopqrstuvxz";

    public String generateUserId(int lenght){
        return generateRandomString(lenght);
    }

    public String generateRandomString(int lenght){

        StringBuilder returnValue = new StringBuilder(lenght);

        for (int i = 0; i<lenght; i++ ){
            returnValue.append(Alfabeto.charAt(RANDOM.nextInt(Alfabeto.length())));
        }

        return new String(returnValue);

    }
}

