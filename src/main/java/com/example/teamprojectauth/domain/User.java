package com.example.teamprojectauth.domain;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@ToString
@XmlRootElement
@NoArgsConstructor
public class User implements Serializable {
    private String username;
    private String password;
}
