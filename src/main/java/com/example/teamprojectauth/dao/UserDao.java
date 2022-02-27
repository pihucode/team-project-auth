package com.example.teamprojectauth.dao;


import com.example.teamprojectauth.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {

    private static final List<User> users;

    static {
        users = new ArrayList<>();
        users.add(new User("user1", "111"));
        users.add(new User("user2", "222"));
    }

    public List<User> getAllUsers() { return users; }

    public boolean isUserValid(String username, String password) {
        Optional<User> possibleUser = users
                .stream()
                .filter(u -> u.getUsername().equals(username)
                        && u.getPassword().equals(password))
                .findFirst();
        return possibleUser.isPresent();
    }

    public boolean addUser(User user) {
        Optional<User> existingUser = users
                .stream()
                .filter(u -> u.getUsername().equals(user.getUsername()))
                .findFirst();
        // username must be unique
        if (!existingUser.isPresent()) {
            users.add(user);
            return true;
        }
        return false;
    }

}
