package com.example.teamprojectauth.dao;

import com.example.teamprojectauth.domain.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonDao extends AbstractHibernateDao<Person> {
    public PersonDao() { setClazz(Person.class);}

    public Person getUserById(int id) {
        return findById(id);
    }

    public void addPerson(Person user) {
        this.getCurrentSession().save(user);
    }

    public void updatePerson(Person person){
        updateRecord(person);
    }
}

