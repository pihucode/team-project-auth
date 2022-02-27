package com.example.teamprojectauth.controller;

import com.example.teamprojectauth.domain.User;
import com.example.teamprojectauth.security.CookieUtil;
import com.example.teamprojectauth.security.JwtUtil;
import com.example.teamprojectauth.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

//    @PostMapping("/register")
//    public String register(HttpServletResponse httpServletResponse,
//                           String username,
//                           String password,
//                           String redirect){
//
//        User user = new User(username, password);
//
//        if (username == null || !userService.addUser(user)){
//            return "register";
//        }
//
//        String token = JwtUtil.generateToken(signingKey, username);
//        CookieUtil.create(httpServletResponse, jwtTokenCookieName, token, false, -1, "localhost");
//
//        return "redirect:" + redirect;
//    }
}