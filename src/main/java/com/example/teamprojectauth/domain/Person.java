package com.example.teamprojectauth.domain;


import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@ToString
@XmlRootElement
@NoArgsConstructor
@Entity
public class Person implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "firstname")
    private String firstname;

    @Basic
    @Column(name = "lastname")
    private String lastname;

    @Basic
    @Column(name = "preferred_name")
    private String preferredname;

    @Basic
    @Column(name = "email")
    private String email; // User email (unique ID)

    @Basic
    @Column(name = "personal_email")
    private String personalEmail;

    @Basic
    @Column(name = "work_email")
    private String workEmail;

    @Basic
    @Column(name = "cellphone")
    private long cellphone;

    @Basic
    @Column(name = "altphone")
    private long altphone;

    @Basic
    @Column(name = "gender")
    private String gender;

    @Basic
    @Column(name = "ssn")
    private long ssn;

    @Basic
    @Column(name="date_birth")
    private Date date_birth;

//    @Basic
//    @Column(name = "date_birth")
//    private Timestamp dateBirth;

}