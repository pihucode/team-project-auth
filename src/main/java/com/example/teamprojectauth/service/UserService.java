package com.example.teamprojectauth.service;

import com.example.teamprojectauth.dao.UserDao;
import com.example.teamprojectauth.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) { this.userDao = userDao; }

    public List<User> getAllUsers() { return userDao.getAllUsers(); }

    public boolean isUserValid(String username, String password) {
        return userDao.isUserValid(username, password);
    }

    public User getValidUser(String username, String password) {
        return userDao.getValidUser(username, password);
    }

    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

}
