package com.example.teamprojectauth.controller;

import com.example.teamprojectauth.domain.RegistrationCredentials;
import com.example.teamprojectauth.domain.User;
import com.example.teamprojectauth.security.CookieUtil;
import com.example.teamprojectauth.security.JwtUtil;
import com.example.teamprojectauth.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RegisterController {
    private static final String jwtTokenCookieName = "JWT-TOKEN";
    private static final String signingKey = "signingKey";
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public boolean register(HttpServletResponse httpServletResponse,
                           @RequestBody RegistrationCredentials cred){

        // return false if username is taken
        if (!userService.isUsernameUnique(cred.getUsername())) return false;

        // create and add new user
        User user = new User();
        user.setEmail(cred.getEmail());
        user.setUsername(cred.getUsername());
        user.setPassword(cred.getPassword());
        user.setHr(false);
        userService.addUser(user);

        String token = JwtUtil.generateToken(signingKey, cred.getEmail());
        CookieUtil.create(httpServletResponse, jwtTokenCookieName, token, false, -1, "localhost");

        return true;
    }
}