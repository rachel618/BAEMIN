package com.example.demo.src.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Setter
@Getter
@AllArgsConstructor
public class PostOrderReq {
    private int userIdx;
    private int storeIdx;
    private String payment;
    private int money;
    private String requestToStore;
    private String requestToRider;
    private String requestReceipt;
    private String receiptPhone;
    private String requestDisposable;
    private Time orderDate;
}
