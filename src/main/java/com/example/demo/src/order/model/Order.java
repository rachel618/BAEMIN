package com.example.demo.src.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
@AllArgsConstructor

public class Order {
    private int orderIdx;
    private int userIdx;
    private int storeIdx;
    private int payment; // 지불방법
    private int price;
    private String requestToStore;
    private String requestToDeli;
    private String requestReceipt;
    private String receiptPhone;
    private String requestDisposable;

    public Order() {
    }
}
