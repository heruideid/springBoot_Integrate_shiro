package com.nostalgia.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
public class Account {
    @Id
    Integer id;
    String userName;
    String password;
    String role;
    String perm;
}
