package com.example.teamprojectauth.controller;

import com.example.teamprojectauth.domain.Employee;
import com.example.teamprojectauth.domain.Person;
import com.example.teamprojectauth.domain.RegistrationCredentials;
import com.example.teamprojectauth.domain.User;
import com.example.teamprojectauth.security.CookieUtil;
import com.example.teamprojectauth.security.JwtUtil;
import com.example.teamprojectauth.service.EmployeeService;
import com.example.teamprojectauth.service.PersonService;
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
    private final PersonService personService;
    private final EmployeeService employeeService;

    public RegisterController(UserService userService,
                              PersonService personService,
                              EmployeeService employeeService) {
        this.userService = userService;
        this.personService = personService;
        this.employeeService = employeeService;
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

        // create and add Person
        Person person = new Person();
        person.setEmail(cred.getEmail());
        personService.addPerson(person);

        // create and add Employee
        Employee employee = new Employee();
        employee.setPerson(person);
        employeeService.addEmployee(employee);

        // if credentials are valid, create new cookie
        String token = JwtUtil.generateToken(signingKey, cred.getEmail());
        CookieUtil.create(httpServletResponse, jwtTokenCookieName, token, false, -1, "localhost");

        return true;
    }
}