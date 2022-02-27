package com.example.teamprojectauth.controller;

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

    @GetMapping("login")
    public String getLogin() {
        return "login get works";
    }

    @PostMapping("login")
    public String login(HttpServletResponse httpServletResponse,
                        @RequestBody User user){
        String username = user.getUsername();
        String password = user.getPassword();

        // if credentials are invalid
        if (username == null || !userService.isUserValid(username, password)){
            return "invalid";
        }

        // if credentials are valid, create new cookie
        String token = JwtUtil.generateToken(signingKey, username);
        CookieUtil.create(httpServletResponse, jwtTokenCookieName, token, false, -1, "localhost");

        // TODO - check if login is HR or employee
        String role = "hr";
        if (role.equals("hr")) return "hr";
        return "employee";
    }
}
