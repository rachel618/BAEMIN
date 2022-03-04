package com.example.demo.src.order.model;

import com.example.demo.src.menu.model.GetMenuOptionRes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PostOrderRes {
    private Time createdAt;  // default current_timestamp
    private int orderIdx;  // auto-increment
    private String storeName;
    private String address;
    private int price;
    private List<GetMenuOptionRes> orderMenu;
    private int deliveryTip;
    private int totalPrice;
    private String payment; // 결제방법
    private String phoneNum;
    private String requestToStore;
    private String requestToRider;

    public PostOrderRes(int orderIdx, String storeName, String address, int price, int deliveryTip, int totalPrice, String payment, String phoneNum, String requestToStore, String requestToRider) {
        this.orderIdx = orderIdx;
        this.storeName = storeName;
        this.address = address;
        this.price = price;
        this.deliveryTip = deliveryTip;
        this.totalPrice = totalPrice;
        this.payment = payment;
        this.phoneNum = phoneNum;
        this.requestToStore = requestToStore;
        this.requestToRider = requestToRider;
    }
}
