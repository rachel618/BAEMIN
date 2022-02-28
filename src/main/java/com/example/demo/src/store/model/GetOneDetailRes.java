package com.example.demo.src.store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetOneDetailRes {
    private String storeName;
    private String address;
    private int minPriceDelivery; // 최소주문금액
    private int minDeliveryTime;
    private int maxDeliveryTime;
    private int minDeliveryTip;
    private int maxDeliveryTip;
    private double rating;
    private int storeType;
    private int numOfReviews;
}
