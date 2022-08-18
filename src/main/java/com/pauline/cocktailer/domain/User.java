package com.pauline.cocktailer.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class User {

    @Id
    private String username;
    private String email;
}
