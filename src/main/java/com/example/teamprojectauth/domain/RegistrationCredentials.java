package com.example.teamprojectauth.domain;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@AllArgsConstructor
@ToString
@XmlRootElement
@NoArgsConstructor
public class RegistrationCredentials {
    private String email;
    private String token;
    private String username;
    private String password;
}
