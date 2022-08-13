package com.uno.userservice.vo;

import lombok.Data;

@Data
public class LoginRequestVo {
    private String email;
    private String password;
}