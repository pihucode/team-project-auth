package com.example.teamprojectauth.dao;


import com.example.teamprojectauth.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDao extends AbstractHibernateDao<User> {

    public UserDao() { setClazz(User.class);}

    //TODO GET USER BY USERNAME OR EMAIL

    public List<User> getAllUsers() { return this.getAll(); }

//    static {
//        users = new ArrayList<>();
//        users.add(new User("employee1", "111", "employee1@mail.com", false));
//        users.add(new User("hr", "asd", "hr@mail.com", true));
//    }


    public boolean isUserValid(String username, String password) {
        List<User> users = this.getAll();
        Optional<User> possibleUser = users
                .stream()
                .filter(u -> u.getUsername().equals(username)
                        && u.getPassword().equals(password))
                .findFirst();
        return possibleUser.isPresent();
    }

    public User getValidUser(String username, String password) {
        List<User> users = this.getAll();
        Optional<User> possibleUser = users
                .stream()
                .filter(u -> u.getUsername().equals(username)
                        && u.getPassword().equals(password))
                .findFirst();
        return possibleUser.orElse(null);
    }

    public String getEmailByUsername(String username) {
        List<User> users = this.getAll();
        Optional<User> possibleUser = users
                .stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();
        if (possibleUser.isPresent()) return possibleUser.get().getEmail();
        return "";
    }

    public boolean isUsernameUnique(String username) {
        List<User> users = this.getAll();
        Optional<User> possibleUser = users
                .stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();
        return !possibleUser.isPresent();
    }

    public boolean addUser(User user) {
        List<User> users = this.getAll();
        Optional<User> existingUser = users
                .stream()
                .filter(u -> u.getUsername().equals(user.getUsername()))
                .findFirst();
        // username must be unique
        if (!existingUser.isPresent()) {
            this.getCurrentSession().save(user);
            return true;
        }
        return false;
    }

    public User getValidUserByEmail(String email, String password) {
        List<User> users = this.getAll();
        Optional<User> possibleUser = users
                .stream()
                .filter(u -> u.getEmail().equals(email)
                        && u.getPassword().equals(password))
                .findFirst();
        return possibleUser.orElse(null);
    }
}
