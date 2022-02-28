package com.example.demo.src.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PatchUserPwdReq {
    private int userIdx;
    private String currentPwd;
    private String newPwd;
}
