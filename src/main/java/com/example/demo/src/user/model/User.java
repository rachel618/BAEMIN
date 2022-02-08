package com.example.demo.src.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private int userIdx;
    private String userName;
    private String nickname;
    private String password;
    private String userEmail;
    private String phoneNum;
    private int status;
//    private Integer point;
//    private String emailPromotionAgree;
//    private String snsPromotionAgree;
//    private String userRating;
}
