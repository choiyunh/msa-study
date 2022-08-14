package com.uno.userservice.dto;

import com.uno.userservice.vo.ResponseOrder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDto {
    private String email;

    private String password;
    private String nickname;
    private String uuid;
    private Date createdAt;
    private Date updatedAt;
    private String encryptedPwd;

    private List<ResponseOrder> orders;
}
