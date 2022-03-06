package com.example.teamprojectauth.service;

import com.example.teamprojectauth.dao.PersonDao;
import com.example.teamprojectauth.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Service
public class PersonService {
    private PersonDao personDao;

    @Autowired
    public void setRegistrationTokenDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public Person getPersonById(int id){
        return personDao.getUserById(id);
    }

    public void addPerson(Person person) {
        personDao.addPerson(person);
    }

    public void updatePerson(Person person) {
        personDao.updatePerson(person);
    }

}

