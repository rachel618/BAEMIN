package com.example.demo.src.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.sql.Time;

@Getter
@Service
@AllArgsConstructor

public class Order {
    private int orderIdx;
    private int userIdx;
    private int storeIdx;
    private int orderMenuIdx;
    private String payment; // 지불방법
    private int price;
    private String requestToStore;
    private String requestToRider;
    private String requestReceipt;
    private String receiptPhone;
    private String requestDisposable;
    private Time orderDate;

    public Order(int userIdx, int storeIdx, String payment, int price, String requestToStore, String requestToRider, String requestReceipt, String receiptPhone, String requestDisposable){}

    public Order(){}
//    public Order(int userIdx, int storeIdx, int payment, int price, String requestToStore, String requestToRider, String requestReceipt, String receiptPhone, String requestDisposable) {
//        this.userIdx = userIdx;
//        this.storeIdx = storeIdx;
//        this.payment = payment;
//        this.price = price;
//        this.requestToStore = requestToStore;
//        this.requestToRider = requestToRider;
//        this.requestReceipt = requestReceipt;
//        this.receiptPhone = receiptPhone;
//        this.requestDisposable = requestDisposable;
//    }
}
