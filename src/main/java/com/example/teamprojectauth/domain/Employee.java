package com.example.teamprojectauth.domain;

import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@ToString
@XmlRootElement
@NoArgsConstructor
@Entity
public class Employee implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_person", referencedColumnName = "id")
    private Person person;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_visa", referencedColumnName = "id")
//    @Basic
//    @Column
//    private int visa;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_house", referencedColumnName = "id")
//    @Basic
//    @Column
//    private int house;

}

