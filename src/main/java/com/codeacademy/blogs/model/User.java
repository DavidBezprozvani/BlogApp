package com.codeacademy.blogs.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@Entity
@Table
public class User {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "userName")
    private String userName;

    @NotBlank
    @Column(name = "password")
    private String password;

    @NotBlank
    @Column(name = "email")
    private String email;


}
