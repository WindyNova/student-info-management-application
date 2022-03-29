package com.windynova.java.sima.entity;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String role;
    private String status;
    private String createTime;
    private String lastLoginTime;
    private String lastLoginIp;
    private String lastLoginLocation;
    private String avatar;

}