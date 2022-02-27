package com.example.teamprojectauth.domain;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@AllArgsConstructor
@ToString
@XmlRootElement
@NoArgsConstructor
public class LoginCredentials {
    private String username;
    private String password;
    private String email;
}
