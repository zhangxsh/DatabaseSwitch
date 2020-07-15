package com.alexzhang.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by alexzhang on 2017/12/16.
 */
@Data
@Entity(name = "mmall_user")
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    private String password;
}
