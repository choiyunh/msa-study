package com.uno.userservice.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private String userEmail;
    private String userNickname;
    private String userPassword;
    private String userId;
    private Date createdAt;
    private Date updatedAt;
    private String encryptedPwd;
}
