package com.example.demo.src.user.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetUserRes {
    private int userIdx;
    private String userName;
    private String nickname;
    private String password;
    private String phoneNum;
    private String userEmail;
    private int status;
//    private char snsPromotionAgree;
//    private char emailPromotionAgree;
}
