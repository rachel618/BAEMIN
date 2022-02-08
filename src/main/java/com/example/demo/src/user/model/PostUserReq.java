package com.example.demo.src.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostUserReq {
    private String nickname;
    private String password;
    private String phoneNum;
    private int status;
    private String userEmail;
    private String userName;
}
