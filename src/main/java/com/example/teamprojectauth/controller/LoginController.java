package com.example.teamprojectauth.controller;

import com.example.teamprojectauth.domain.LoginCredentials;
import com.example.teamprojectauth.domain.User;
import com.example.teamprojectauth.security.CookieUtil;
import com.example.teamprojectauth.security.JwtUtil;
import com.example.teamprojectauth.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoginController {

    private static final String jwtTokenCookieName = "JWT-TOKEN";
    private static final String signingKey = "signingKey";
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("login")
    public String login(HttpServletResponse httpServletResponse,
                        @RequestBody LoginCredentials credentials){
        String username = credentials.getUsername();
        String email = credentials.getEmail();
        String password = credentials.getPassword();

        // check if credentials are invalid
        User user;
        if (email.equals("")) {
            user = userService.getValidUser(username, password);
        } else {
            user = userService.getValidUserByEmail(email, password);
        }
        if (user == null) return "invalid";

        // if credentials are valid, create new cookie
        String jwtToken = JwtUtil.generateToken(signingKey, user.getEmail());
        System.out.println(jwtToken);
        CookieUtil.create(httpServletResponse, jwtTokenCookieName, jwtToken, false, -1, "localhost");

        // check if login is HR or employee
        if (user.isHr()) return "hr";
        return "employee";
    }

    @GetMapping("user-email/{username}")
    public String getUserEmail(@PathVariable String username) {
        return userService.getEmailByUsername(username);
    }
}
