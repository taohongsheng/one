package com.hongsheng.one.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String password;
    private String role;
}
