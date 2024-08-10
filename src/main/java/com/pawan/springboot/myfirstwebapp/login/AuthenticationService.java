package com.pawan.springboot.myfirstwebapp.login;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    boolean isValidUser(String username, String password) {
        boolean isValidName = username.equalsIgnoreCase("pawan");
        boolean isValidPassword = password.equalsIgnoreCase("pawan");
        return isValidName && isValidPassword;
    }
}
